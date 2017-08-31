package com.madhouse.ssp

import java.io.{File, InputStreamReader}
import java.net.URI

import com.madhouse.ssp.entity.{LogType, Output}
import com.typesafe.config.{Config, ConfigFactory}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

/**
  * Created by Sunxiang on 2017-07-27 09:12.
  */
class Configure(file: String) extends Serializable {

  val fs: FileSystem = FileSystem.get(new Configuration())

  implicit private val config: Config = {
    logger(s"config file: $file")
    val uri = new URI(file)
    uri.getScheme match {
      case "file" => ConfigFactory.parseFile(new File(uri)).getConfig("app")
      case "hdfs" => ConfigFactory.parseReader(new InputStreamReader(fs.open(new Path(uri), 10240))).getConfig("app")
      case _ => throw new IllegalArgumentException(s"unknown config: $file")
    }
  }

  private def getOrElse[T](path: String, default: T)(implicit config: Config) = {
    if (config.hasPath(path))
      default match {
        case _: String => config.getString(path).asInstanceOf[T]
        case _: Int => config.getInt(path).asInstanceOf[T]
        case _: Long => config.getLong(path).asInstanceOf[T]
        case _: Boolean => config.getBoolean(path).asInstanceOf[T]
        case _ => default
      }
    else default
  }

  val slideDuration = getOrElse("spark.streaming.slide_duration", 30)
  val kafkaMaxRatePerPartition = getOrElse("spark.streaming.kafka_max_rate_per_partition", 128)

  val kafkaBrokers = getOrElse("kafka.brokers", "localhost:9092")
  val topicName = getOrElse("kafka.topic", "topic")

  val zkServers = getOrElse("zookeeper.servers", "localhost:2181")

  val offsetPath = {
    val offsetBasePath = getOrElse("zookeeper.offset_key", "/offsets/log_collector/topics")
    if (offsetBasePath.endsWith("/")) offsetBasePath.dropRight(1) else offsetBasePath
  }

  private val outputPath = {
    val path = getOrElse("output.path", "/madssp/bidlogs/typename")
    if (path.endsWith("/")) path.dropRight(1) else path
  }

  private val outputPrefix = getOrElse("output.prefix", "madssp.topic")
  private val outputSuffix = getOrElse("output.suffix", "log.avro")
  private val rotateIntervalMs = getOrElse("output.rotate_interval_ms", 300000)

  val output = Output(outputPath, outputPrefix, outputSuffix, rotateIntervalMs)

  val logType = LogType.withName(getOrElse("log_type", ""))
}
