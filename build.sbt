name := "example-sbt-findbugs"
version := "0.1"
scalaVersion := "2.11.8"


libraryDependencies ++= Seq(
  "com.google.code.findbugs" % "jsr305" % "3.0.1",
  "args4j" % "args4j" % "2.33",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework" % "spring-context" % "4.2.5.RELEASE",
  "commons-logging" % "commons-logging" % "1.0.2",
  "commons-io" % "commons-io" % "2.0",
  "org.apache.httpcomponents" % "httpclient" % "4.3.5",
  "org.apache.httpcomponents" % "httpcomponents-core" % "4.3.3",
  "commons-net" % "commons-net" % "3.3",
  "commons-codec" % "commons-codec" % "1.6",
  "org.apache.poi" % "poi" % "3.6",
  "commons-beanutils" % "commons-beanutils" % "1.9.0",
  "commons-fileupload" % "commons-fileupload" % "1.2.1"
)