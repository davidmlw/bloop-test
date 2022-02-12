
lazy val foo = (project in file("."))
  .settings(
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % Test
  )
