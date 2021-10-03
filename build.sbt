name := "cyber-dojo-answers-scala"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.2"

scalacOptions ++= Seq(
  //"-Ypartial-unification"
  "-Xfatal-warnings"
  ,"-feature"
  ,"-deprecation"
)

fork := true

libraryDependencies := Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.typelevel" %% "cats-core" % "2.0.0" withSources() withJavadoc(),
  "org.typelevel" %% "cats-effect" % "2.0.0" withSources() withJavadoc(),
  "org.typelevel" %% "cats-free" % "2.0.0" withSources() withJavadoc(),
)
