import de.johoop.jacoco4sbt._
import JacocoPlugin._

scalaVersion := "2.10.3"

jacoco.settings

libraryDependencies += "junit" % "junit-dep" % "4.10" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.4"