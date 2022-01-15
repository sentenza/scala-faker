import sbt._
import Keys._

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / crossScalaVersions := Seq("2.12.15", "2.13.8", "3.1.0")
ThisBuild / githubWorkflowJavaVersions := Seq(JavaSpec.temurin("11.0.13"))
ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
ThisBuild / githubWorkflowPublishTargetBranches:= Seq()

lazy val scalaFaker = (project in file("."))
  .settings(
    name := "scala-faker",
    organization := "com.github.sentenza",
    crossScalaVersions := Seq("2.12.15", "2.13.8", "3.1.0"),
    scalaVersion := "2.13.8",

    sbtPlugin := false,

    scalacOptions ++= Seq("-deprecation", "-Xcheckinit", "-encoding", "utf8", "-g:vars", "-unchecked", "-optimize"),
    Compile / parallelExecution := true,
    Test / parallelExecution := true,
    homepage := Some(new java.net.URL("https://github.com/sentenza/scala-faker/")),
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
        url("https://github.com/sentenza/scala-faker"),
        "scm:git@github.com:sentenza/scala-faker.git"
      )
    ),

    developers := List(
      Developer(id="j1mr10rd4n", name="Jim Riordan", email="jim@j1mr10rd4n.info", url=url("https://github.com/j1mr10rd4n")),
      Developer(id="justwrote", name="Just Wrote", email="unknown", url=url("https://github.com/justwrote")),
      Developer(id="sentenza", name="Alfredo Torre", email="sentenza@github.com", url=url("https://github.com/sentenza"))
    ),

    initialCommands := "import faker._",

    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.6.0",
      "org.yaml" % "snakeyaml" % "1.30",
      "org.scalatest" %% "scalatest" % "3.2.10" % Test
    ),

    // enable publishing the main API jar
    Compile / publishArtifact := true
  )

Global / onChangedBuildSource := ReloadOnSourceChanges

