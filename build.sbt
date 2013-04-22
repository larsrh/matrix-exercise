scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test",
  "org.specs2" %% "specs2" % "1.12.3" % "test"
)

resolvers += Resolver.sonatypeRepo("releases")

// vim: expandtab:ts=2:sw=2
