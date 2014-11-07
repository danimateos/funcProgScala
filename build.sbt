name := "func_prog_scala"

version := "1.0.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.specs2" %% "specs2" % "2.4.9" % "test"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
