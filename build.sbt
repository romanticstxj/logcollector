import sbt.Keys._
import Dependencies._
import CompileOptions._

lazy val commonSettings = Seq(
  organization := "com.madhouse.ssp",
  name := "logcollector",
  version := "1.1.0",
  scalaVersion := "2.11.11",
  scalacOptions := scalaCompile,
  javacOptions := javaCompile
)

lazy val logCollector = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= rootDeps,
    resolvers ++= rootResolvers
  )

assemblyJarName in assembly := name.value + "-" + version.value + "-assembly.jar"

mainClass in assembly := Some("com.madhouse.ssp.LogCollector")

assemblyMergeStrategy in assembly := {
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith "UnusedStubClass.class" => MergeStrategy.first
  case "application.conf" => MergeStrategy.concat
  case x => {
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
  }
}