ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "anja"
ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "dockerized-spark-app"
  )

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1" % "provided"

enablePlugins(DockerPlugin)

docker / dockerfile := {
  val jarFile: File = (Compile / packageBin / sbt.Keys.`package`).value
  val jarTarget = s"/opt/spark/jars/${jarFile.getName}"
  new Dockerfile {
    from("spark:v3.2.1")
    add(jarFile, jarTarget)
    user("root")
    entryPoint("/opt/spark/bin/spark-submit", "--conf", "spark.jars.ivy=/tmp/.ivy", jarTarget)
  }
}

docker / imageNames := Seq(
  ImageName(s"${organization.value}/${name.value}:${version.value}")
)