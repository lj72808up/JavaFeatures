name := "Demo"

val hadoopCommon= "org.apache.hadoop" % "hadoop-common" % "2.7.5"

lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.8"
)

lazy val nettydemo = (project in file("./netty-demo"))
  .settings(commonSettings:_*)
  .settings(
    name := "nettydemo",
    libraryDependencies  ++= Seq("io.netty" % "netty-all" % "4.1.32.Final")
  ) //.dependsOn(sub2)

lazy val root = (project in file("."))
  .settings(commonSettings:_*)
  .settings(
    name := "root"
  ).aggregate(nettydemo)