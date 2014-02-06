import com.typesafe.tools.mima.plugin.MimaPlugin.mimaDefaultSettings

import com.typesafe.tools.mima.plugin.MimaKeys.previousArtifact

import VersionKeys._

name := "scalacheck"

version := "1.11.4-SNAPSHOT"

organization := "org.scalacheck"

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("http://www.scalacheck.org"))

scalaVersion := "2.10.3"

scalaParserCombinatorsVersion := "1.0.0-RC5"

scalaXmlVersion := "1.0.0-RC7"

crossScalaVersions := Seq("2.9.3", "2.10.3", "2.11.0-M8")

mimaDefaultSettings

previousArtifact := Some("org.scalacheck" % "scalacheck_2.10" % "1.11.3")

resolvers += "sonatype" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "org.scala-sbt" %  "test-interface" % "1.0"

libraryDependencies ++= (
  if((scalaVersion.value startsWith "2.9") || (scalaVersion.value startsWith "2.10")) Seq.empty
  else Seq("org.scala-lang.modules" %% "scala-parser-combinators" % scalaParserCombinatorsVersion.value,
           "org.scala-lang.modules" %% "scala-xml" % scalaXmlVersion.value)
)

javacOptions ++= Seq("-Xmx1024M")

scalacOptions += "-deprecation"

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>https://github.com/rickynils/scalacheck</url>
    <connection>scm:git:git@github.com:rickynils/scalacheck.git</connection>
  </scm>
  <developers>
    <developer>
      <id>rickynils</id>
      <name>Rickard Nilsson</name>
    </developer>
  </developers>
)
