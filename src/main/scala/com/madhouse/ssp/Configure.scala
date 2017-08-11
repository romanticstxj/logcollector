package com.madhouse.ssp

import java.io.{File, InputStreamReader}
import java.net.URI
import java.time.ZoneId

import com.madhouse.ssp.entity.{LogType, Output}
import com.typesafe.config.{Config, ConfigFactory}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

import scala.collection.JavaConversions._

/**
  * Created by Sunxiang on 2017-07-27 09:12.
  */
object Configure {

  var fs: FileSystem = _

  implicit private var config: Config = _

  def initConf(hadoopEnv: String, conf: String) = {
    logger(s"hadoop env: $hadoopEnv, config path: $conf")

    fs = FileSystem.get {
      val conf = ConfigFactory.load("hadoop").getConfig(hadoopEnv)

      val configuration = new Configuration()
      conf.entrySet().iterator() foreach { c =>
        val key = c.getKey
        configuration.set(c.getKey, conf.getString(key))
      }
      configuration
    }

    config = if (conf.startsWith("file://")) {
      ConfigFactory.parseFile(new File(new URI(conf))).getConfig("app")
    } else {
      val path = new Path(conf)
      ConfigFactory.parseReader(new InputStreamReader(fs.open(path, 10240))).getConfig("app")
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

  lazy val slideDuration = getOrElse("spark.streaming.slide_duration", 30)
  lazy val kafkaMaxRatePerPartition = getOrElse("spark.streaming.kafka_max_rate_per_partition", 128)

  lazy val kafkaBrokers = getOrElse("kafka.brokers", "localhost:9092")
  lazy val topicName = getOrElse("kafka.topic", "topic")

  lazy val zkServers = getOrElse("zookeeper.servers", "localhost:2181")

  lazy val offsetPath = {
    val offsetBasePath = getOrElse("zookeeper.offset_key", "/offsets/log_collector/topics")
    if (offsetBasePath.endsWith("/")) offsetBasePath.dropRight(1) else offsetBasePath
  }

  lazy private val outputPath = {
    val path = getOrElse("output.path", "/madssp/bidlogs/typename")
    if (path.endsWith("/")) path.dropRight(1) else path
  }

  lazy private val outputPrefix = getOrElse("output.prefix", "madssp.topic")
  lazy private val outputSuffix = getOrElse("output.suffix", "log.avro")
  lazy private val rotateIntervalMs = getOrElse("output.rotate_interval_ms", 300000)

  lazy val output = Output(outputPath, outputPrefix, outputSuffix, rotateIntervalMs)

  lazy val logType = LogType.withName(getOrElse("log_type", ""))
}
