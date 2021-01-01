import sbt._
import Keys._
import sbtrelease.ReleasePlugin._

lazy val scalaFaker = (project in file("."))
  .settings(
    name := "scala-faker",
    organization := "com.github.pjfanning",
    crossScalaVersions := Seq("2.12.12", "2.13.4"),
    scalaVersion := crossScalaVersions.value.last,

    sbtPlugin := false,

    publishArtifact in (Compile, packageDoc) := false,
    scalacOptions ++= Seq("-deprecation", "-Xcheckinit", "-encoding", "utf8", "-g:vars", "-unchecked", "-optimize"),
    parallelExecution := true,
    parallelExecution in Test := true,
    homepage := Some(new java.net.URL("https://github.com/pjfanning/scala-faker/")),
    description := "A library for generating fake data.",

    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),

    licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),

    scmInfo := Some(
      ScmInfo(
        url("https://github.com/pjfanning/scala-faker"),
        "scm:git@github.com:pjfanning/scala-faker.git"
      )
    ),

    developers := List(
      Developer(id="j1mr10rd4n", name="Jim Riordan", email="jim@j1mr10rd4n.info", url=url("https://github.com/j1mr10rd4n")),
      Developer(id="justwrote", name="Just Wrote", email="unknown", url=url("https://github.com/justwrote"))
    ),

    initialCommands := "import faker._",

    libraryDependencies ++= Seq(
      "org.yaml" % "snakeyaml" % "1.27",
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    ),

    // enable publishing the main API jar
    publishArtifact in (Compile, packageDoc) := true
  )

