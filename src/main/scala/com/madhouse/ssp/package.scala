package com.madhouse

import java.time.format.DateTimeFormatter.ofPattern
import java.time.{Duration, Instant, LocalDateTime}

import com.madhouse.ssp.Configure._
import com.madhouse.ssp.util.{FsInput, ZkStore}
import _root_.kafka.common.TopicAndPartition
import org.apache.avro.Schema
import org.apache.avro.file.{DataFileStream, DataFileWriter}
import org.apache.avro.specific.{SpecificDatumReader, SpecificDatumWriter, SpecificRecordBase => Record}
import org.apache.hadoop.fs.Path
import org.apache.spark.streaming.kafka.OffsetRange

import scala.collection.JavaConverters._
import scala.collection.mutable

/**
  * Created by Sunxiang on 2017-07-27 09:10.
  */
package object ssp {

  def writeRecord(records: Array[Record], saveTopicOffsets: () => Unit) = {

    val ts = Instant.now
    val writerCache = mutable.Map[Path, DataFileWriter[Record]]()

    def getFileWriter(ts: Long, schema: Schema) = {
      val timestamp = ts - ts % output.rotateIntervalMs
      val fileTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zone)
      val dayHour = fileTime.format(ofPattern("'day'=yyyyMMdd/'hour'=HH"))
      val filePath = new Path(s"${output.path}/$dayHour/${output.prefix}.$timestamp.${output.suffix}")
      writerCache.getOrElse(filePath, {
        val writer = new DataFileWriter[Record](new SpecificDatumWriter[Record]())
        writer.create(schema, fs.create(new Path(s"$filePath.tmp")))
        writerCache += (filePath -> writer)
        writer
      })
    }

    if (records.length > 0) {
      val schema = records.head.getSchema
      records foreach { r =>
        val time = try { r.get("timestamp").asInstanceOf[Long] } catch { case _: Exception => ts.toEpochMilli }
        getFileWriter(time, schema).append(r)
      }
    }

    println(s"write tmp file took: ${(Duration.between(ts, Instant.now).toMillis) / 1000F} s")

    writerCache foreach { case (filePath, write) =>
      write.close()
      val tmpFilePath = new Path(s"$filePath.tmp")

      if (fs.exists(filePath)) {
        val len = fs.getFileStatus(filePath).getLen
        val fis = fs.open(filePath)

        val writer = new DataFileWriter[Record](new SpecificDatumWriter[Record]()).appendTo(new FsInput(len, fis), fs.append(filePath))
        val reader = new DataFileStream[Record](fs.open(tmpFilePath), new SpecificDatumReader[Record]())

        writer.appendAllFrom(reader, false)

        reader.close
        writer.close
        fs.delete(tmpFilePath, false)
      } else fs.rename(tmpFilePath, filePath)
    }
    writerCache.clear()
    saveTopicOffsets()
    println(s"write records count: ${records.length}, took: ${(Duration.between(ts, Instant.now).toMillis) / 1000F} s")
  }

  def getTopicOffsets(topic: String): Option[Map[TopicAndPartition, Long]] = {
    ZkStore.withZk { client =>
      val topicOffsetPath = s"$offsetPath/$topic"
      val num = client.countChildren(topicOffsetPath)
      num match {
        case 0 =>
          println(s"no child found in $topicOffsetPath")
          None
        case _ =>
          val cs = client.getChildren(offsetPath).asScala
          println(s"zookeeper children: ${cs.mkString(",")}")
          val offsets = cs.map(c => TopicAndPartition(topic, c.toInt) -> client.readData[Long](s"$topicOffsetPath/$c")).toMap
          Some(offsets)
      }
    }
  }

  def saveTopicOffsets(offsetRanges: Array[OffsetRange]) = {
    ZkStore.withZk { client =>
      offsetRanges foreach { o =>
        val topicOffsetPath = s"$offsetPath/${o.topic}/${o.partition}"
        println(s"offset topic ${o.topic}, partition ${o.partition}: ${o.fromOffset} -> ${o.untilOffset}")
        if (!client.exists(topicOffsetPath)) {
          client.createPersistent(topicOffsetPath, true)
        }
        client.writeData(topicOffsetPath, o.untilOffset.toString)
      }
    }
  }
}
