package com.madhouse.ssp

/**
 * Created by Sunxiang on 2017-07-27 17:12.
 */
import com.madhouse.ssp.avro._
import com.madhouse.ssp.util._
import _root_.kafka.message.MessageAndMetadata
import _root_.kafka.serializer.{DefaultDecoder, StringDecoder}
import org.apache.avro.specific.SpecificRecordBase
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka._
import org.apache.spark.streaming.{Seconds, StreamingContext}

object LogCollector extends App {
  import Configure._

  private val (hadoopEnv, configFile) = args.length match {
    case 1 => ("production", args(0))
    case 2 => (args(0), args(1))
    case _ => throw new IllegalArgumentException("the parameter length must equal 2")
  }

  require(Seq("develop", "beta", "production").contains(hadoopEnv), s"invalid hadoop environment $hadoopEnv")

  initConf(hadoopEnv, configFile)

  val sparkConf = new SparkConf()
    .setAppName(s"LogCollector-$logType")
    .set("spark.streaming.kafka.maxRatePerPartition", s"$kafkaMaxRatePerPartition")
    .registerKryoClasses(Array(classOf[MediaBid], classOf[DSPBid], classOf[ImpressionTrack], classOf[ClickTrack], classOf[WinNotice]))

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
        println(e.toString)
        null
    }
  }

  val topicOffset = getTopicOffsets(topicName)

  val ssc = new StreamingContext(sparkConf, Seconds(slideDuration))
  ssc.sparkContext.hadoopConfiguration.addResource(fs.getConf)

  val streaming = topicOffset match {
    case Some(offset) =>
      println(s"offset path: $offsetPath, value: $offset")
      val messageHandler = (mmd: MessageAndMetadata[String, Array[Byte]]) => (mmd.key, mmd.message)
      KafkaUtils.createDirectStream[String, Array[Byte], StringDecoder, DefaultDecoder, (String, Array[Byte])](ssc, kafkaParams, offset, messageHandler)
    case None =>
      println(s"offset path: $offsetPath, value: null")
      KafkaUtils.createDirectStream[String, Array[Byte], StringDecoder, DefaultDecoder](ssc, kafkaParams, Set(topicName))
  }

  var offsetRanges = Array[OffsetRange]()

  val recordsDStream = streaming transform { (rdd, _) =>
    offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges

    rdd map { case (_, bytes) => AvroUtil.recordDecode[SpecificRecordBase](bytes) } filter { _ != null }
  }

  recordsDStream foreachRDD { rdd =>
    writeRecord(rdd.collect(), () => saveTopicOffsets(offsetRanges))
  }

  ssc.start()
  ssc.awaitTermination()
}