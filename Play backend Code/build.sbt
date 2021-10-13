name := """MyBankApp"""
organization := "com.nexxo"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins( PlayJava, PlayEbean)
scalaVersion := "2.13.1"
libraryDependencies ++= Seq(guice,javaJdbc, "mysql" % "mysql-connector-java" % "8.0.17")
libraryDependencies += javaForms
libraryDependencies ++= Seq(
  ehcache,
  "org.apache.commons" % "commons-io" % "1.3.2",
  "org.json" % "json" % "20190722"
)

