import sbt._

object Dependencies {
  // Versions
  val sparkVersion = "2.2.0"
  val avroVersion  = "1.8.2"

  // Libraries
  val config     = "com.typesafe"       % "config"                    % "1.3.1"
  val hadoopC    = "org.apache.hadoop"  % "hadoop-client"             % "2.7.3"        % Provided
  val sparkS     = "org.apache.spark"  %% "spark-streaming"           % sparkVersion   % Provided  exclude("org.apache.hadoop", "hadoop-client")
  val sparkSK    = "org.apache.spark"  %% "spark-streaming-kafka-0-8" % sparkVersion
  val avro       = "org.apache.avro"    % "avro"                      % avroVersion


  // Projects
  val rootDeps = Seq(config, hadoopC, sparkS, sparkSK, avro)

  // Resolvers
  val rootResolvers = Seq()
}

