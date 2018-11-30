lazy val `advent-of-code-2018` = (project in file("."))
  .settings(
    organization := "com.ikempf",
    name := "advent-of-code-2018",
    scalaVersion := "2.12.7",
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= List(
      "org.typelevel" %% "cats-core" % "1.4.0",
    ),
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6")
  )
