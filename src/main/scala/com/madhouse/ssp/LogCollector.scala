package com.madhouse.ssp

/**
 * Created by Sunxiang on 2017-07-27 17:12.
 */
import com.madhouse.ssp.avro._
import com.madhouse.ssp.entity.LogType._
import com.madhouse.ssp.util._
import kafka.message.MessageAndMetadata
import kafka.serializer.{DefaultDecoder, StringDecoder}
import org.apache.avro.specific.{SpecificRecordBase => Record}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka._
import org.apache.spark.streaming.{Seconds, StreamingContext}

object LogCollector extends App {

  require(args.length == 1, s"config file is not set")

  implicit val configure = new Configure(args(0))
  import configure._

  val schema = logType match {
    case MEDIABID => MediaBid.SCHEMA$
    case DSPBID => DSPBid.SCHEMA$
    case IMPRESSION => ImpressionTrack.SCHEMA$
    case CLICK => ClickTrack.SCHEMA$
    case WINNOTICE => WinNotice.SCHEMA$
  }

  val sparkConf = new SparkConf()
    .setAppName(s"LogCollector-$logType")
    .set("spark.streaming.kafka.maxRatePerPartition", s"$kafkaMaxRatePerPartition")

  val kafkaParams = Map(
    "metadata.broker.list" -> kafkaBrokers,
    "zookeeper.connection.timeout.ms" -> "3000",
    "group.id" -> s"kafka-log-collector-$logType"
  )

  val offsetValue = ZkStore.withZk[String] { client =>
    try {
      client.readData(offsetPath)
    } catch {
      case e: Exception =>
        logger(e.toString)
        null
    }
  }

  val topicOffset = getTopicOffsets(topicName)

  val ssc = new StreamingContext(sparkConf, Seconds(slideDuration))

  val streaming = topicOffset match {
    case Some(offset) =>
      logger(s"offset path: $offsetPath, value: $offset")
      val messageHandler = (mmd: MessageAndMetadata[String, Array[Byte]]) => (mmd.key, mmd.message)
      KafkaUtils.createDirectStream[String, Array[Byte], StringDecoder, DefaultDecoder, (String, Array[Byte])](ssc, kafkaParams, offset, messageHandler)
    case None =>
      logger(s"offset path: $offsetPath, value: null")
      KafkaUtils.createDirectStream[String, Array[Byte], StringDecoder, DefaultDecoder](ssc, kafkaParams, Set(topicName))
  }

  var offsetRanges = Array[OffsetRange]()

  val recordsDStream = streaming transform { (rdd, _) =>
    offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
    rdd map { _._2 }
  }

  recordsDStream foreachRDD { (rdd, time) =>
    val records = rdd.collect() map { bs => AvroUtil.recordDecode[Record](bs, schema) } filter { _ != null }
    writeRecord((records, time), schema, () => saveTopicOffsets(offsetRanges))
  }

  ssc.start()
  ssc.awaitTermination()
}