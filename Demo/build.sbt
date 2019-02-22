name := "Demo"

val hadoopCommon= "org.apache.hadoop" % "hadoop-common" % "2.7.5"

lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.8"
)

lazy val nettydemo = (project in file("./netty-demo"))
  .settings(commonSettings:_*)
  .settings(
    name := "netty-demo",
    libraryDependencies  ++= Seq("io.netty" % "netty-all" % "4.1.32.Final")
  ) //.dependsOn(sub2)

lazy val rpcnettydemo = (project in file("./rpc-netty-demo"))
  .settings(commonSettings:_*)
  .settings(
    name := "rpc-netty-demo",
    libraryDependencies  ++= Seq("io.netty" % "netty-all" % "4.1.32.Final")
  )

lazy val jdkthreaddemo = (project in file("./jdk_thread-demo"))
  .settings(commonSettings:_*)
  .settings(
    name := "jdk_thread-demo",
  ) //.dependsOn(sub2)

lazy val swordtoffer = (project in file("./swordtoffer"))
  .settings(commonSettings:_*)
  .settings(
    name := "swordtoffer",
  ) //.dependsOn(sub2)

lazy val root = (project in file("."))
  .settings(commonSettings:_*)
  .settings(
    name := "root"
  ).aggregate(nettydemo,jdkthreaddemo,swordtoffer,rpcnettydemo)