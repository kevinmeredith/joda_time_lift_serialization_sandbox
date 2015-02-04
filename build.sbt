name := "serialize joda time objects without time-zone in Lift"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "net.liftweb" % "lift-webkit_2.10" % "3.0-M1"

libraryDependencies += "joda-time" % "joda-time" % "2.7"

// Fork JVM when `run`-ing SBT
// http://stackoverflow.com/a/5265162/409976
fork in run := true