ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.kumargaurav"
ThisBuild / scalaVersion := "2.12.13"
lazy val libs = new {
  val librariesBom = "com.google.cloud" % "libraries-bom" % "24.3.0"
}

lazy val props = new {
  val mavenCompilerSource = "1.8"
  val mavenCompilerTarget = "1.8"
  val encoding = "UTF-8"
  val scalaVersion = "2.12.13"
  val scalaCompatVersion = "2.12"
  val sparkVersion = "3.1.1"
  val bigquerysparkVersion = "0.20.0"
  val spec2Version = "4.2.0"
}
lazy val root = (project in file("."))
  .settings(
    name := "scalapractice",
    idePackagePrefix := Some("com.kumargaurav"),
    resolvers ++= List(
      "restlet" at "https://maven.restlet.com/",
      "Oracle Released Java Packages" at "https://download.oracle.com/maven"
    ),
    libraryDependencies ++= List(
      "org.apache.spark" %% "spark-core" % props.sparkVersion % "provided",
      "org.apache.spark" %% "spark-sql" % props.sparkVersion % "provided",
      "org.scala-lang" % "scala-library" % props.scalaVersion,
      "com.typesafe" % "config" % "1.3.1",
      "org.apache.spark" % s"spark-sql_${props.scalaCompatVersion}" % props.sparkVersion,
      "com.google.cloud" % "google-cloud-secretmanager" % "2.1.0"
    )
  )
ThisBuild / assemblyMergeStrategy := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList("org", "apache", "spark", xs @ _*) => MergeStrategy.discard
  case PathList("module-info.class")         => MergeStrategy.discard
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}

ThisBuild / assemblyShadeRules := Seq(
  ShadeRule.rename("org.apache.commons.io.**" -> "shadeio.@1").inAll
)

