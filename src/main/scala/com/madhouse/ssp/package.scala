package com.madhouse

import java.time.format.DateTimeFormatter.ofPattern
import java.time.{Duration, Instant, LocalDateTime, ZoneId}

import kafka.common.TopicAndPartition
import com.madhouse.ssp.util.{FsInput, ZkStore}
import org.apache.avro.Schema
import org.apache.avro.file.DataFileWriter
import org.apache.avro.specific.{SpecificDatumWriter, SpecificRecordBase => Record}
import org.apache.hadoop.fs.Path
import org.apache.spark.streaming.kafka.OffsetRange

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * Created by Sunxiang on 2017-07-27 09:10.
  */
package object ssp {

  val zone = ZoneId.of("Asia/Shanghai")

  val logger: String => Unit = { msg =>
    val time = LocalDateTime.ofInstant(Instant.now(), zone).format(ofPattern("yyyy-MM-dd HH:mm:ss"))
    println(s"[$time] $msg")
  }

  def writeRecord(records: Array[Record], schema: Schema, saveTopicOffsets: () => Unit)(implicit configure: Configure) = {
    import configure._
    val ts = Instant.now
    val writerCache = mutable.Map[Path, DataFileWriter[Record]]()

    def getFileWriter(ts: Long, schema: Schema) = {
      val timestamp = ts - ts % output.rotateIntervalMs
      val fileTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zone)
      val dayHour = fileTime.format(ofPattern("'day'=yyyyMMdd/'hour'=HH"))
      val filePath = new Path(s"${output.path}/$dayHour/${output.prefix}.$timestamp.${output.suffix}")
      logger(s"ts: $ts, file path: $filePath")
      val writer = new DataFileWriter[Record](new SpecificDatumWriter[Record]())
      writerCache.getOrElse(filePath, {
        if (fs.exists(filePath)) {
          val len = fs.getFileStatus(filePath).getLen
          writer.appendTo(new FsInput(len, fs.open(filePath)), fs.append(filePath))
        } else writer.create(schema, fs.create(filePath))

        writerCache += (filePath -> writer)
        writer
      })
    }

    getFileWriter(ts.toEpochMilli, schema)

    records foreach { r =>
      val time = try { r.get("time").asInstanceOf[Long] } catch { case _: Exception => ts.toEpochMilli }
      getFileWriter(time, schema).append(r)
    }

    logger(s"write file took: ${Duration.between(ts, Instant.now).toMillis / 1000F} s")

    writerCache foreach { _._2.close }
    writerCache.clear()

    saveTopicOffsets()

    logger(s"write records count: ${records.length}, took: ${Duration.between(ts, Instant.now).toMillis / 1000F} s")
  }

  def getTopicOffsets(topic: String)(implicit configure: Configure): Option[Map[TopicAndPartition, Long]] = {
    ZkStore.withZk { client =>
      val topicOffsetPath = s"${configure.offsetPath}/$topic"
      val num = client.countChildren(topicOffsetPath)
      num match {
        case 0 =>
          logger(s"no child found in $topicOffsetPath")
          None
        case _ =>
          val cs = client.getChildren(topicOffsetPath).asScala
          logger(s"zookeeper children: ${cs.mkString(",")}")
          val offsets = cs.map(c => TopicAndPartition(topic, c.toInt) -> client.readData[String](s"$topicOffsetPath/$c").toLong).toMap
          Some(offsets)
      }
    }
  }

  def saveTopicOffsets(offsetRanges: Array[OffsetRange])(implicit configure: Configure) = {
    ZkStore.withZk { client =>
      offsetRanges foreach { o =>
        val topicOffsetPath = s"${configure.offsetPath}/${o.topic}/${o.partition}"
        if (!client.exists(topicOffsetPath)) {
          client.createPersistent(topicOffsetPath, true)
        }
        client.writeData(topicOffsetPath, o.untilOffset)

        logger(s"save offset topic ${o.topic}, partition ${o.partition}: ${o.fromOffset} -> ${o.untilOffset}")
      }
    }
  }
}
