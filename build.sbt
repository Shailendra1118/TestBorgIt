import play.sbt.routes.RoutesKeys.routesGenerator

name := "TestBorgIt"

version := "0.1"

scalaVersion := "2.13.5"
//scalaVersion := "2.12.8"

//scalacOptions ++= Seq("-encoding", "UTF-8", "-target:jvm-1.8", "-unchecked", "-deprecation", "-feature", "-Xlint:-unused,_", "-Xlint", "-Xfatal-warnings")

val akkaV = "2.5.20"
val akkaHttpV = "10.1.8"
val asyncHttpClientV = "2.3.0"
val flywayV = "4.0.3"
val gatlingV = "2.2.0"
val guavaV = "22.0"
val hsqldbV = "2.4.0"
val joseV = "0.5.1"
val jwtV = "1.2.2"
val logbackV = "1.2.3"
val mockitoV = "1.4.0"
val pac4jV = "2.2.1"
val pac4jPlayV = "5.0.0"
val playJsonV = "2.7.2"
val commonLibV = "0.7.37.+"
val postgresV = "9.4.1212"
val redisClientV = "3.9"
val scalatestPlayV = "3.1.2"
val scalatestV = "3.0.5"
val scalazV = "7.2.27"
val signPostV = "1.2.1.2"
val slickV = "3.2.3"
val slickPlayV = "3.0.3"


lazy val service = Project("mp-accounts", file("."))
  .settings(
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % logbackV,
      "com.google.guava" % "guava" % guavaV
    ))
/*
      "com.typesafe.akka" %% "akka-actor" % akkaV,
      "com.typesafe.akka" %% "akka-cluster" % akkaV,
      "com.typesafe.akka" %% "akka-cluster-tools" % akkaV,
      "com.typesafe.akka" %% "akka-cluster-metrics" % akkaV,
      "com.typesafe.akka" %% "akka-http" % akkaHttpV,
      "com.typesafe.akka" %% "akka-slf4j" % akkaV,
      "com.typesafe.akka" %% "akka-stream" % akkaV,
      "com.typesafe.play" %% "play-json" % playJsonV,
      "com.typesafe.play" %% "play-slick" % slickPlayV,
      "com.typesafe.slick" %% "slick" % slickV,
      "io.igl" %% "jwt" % jwtV,
      "net.debasishg" %% "redisclient" % redisClientV,

      "oauth.signpost" % "signpost-core" % signPostV,
      "oauth.signpost" % "signpost-commonshttp4" % signPostV,

      "org.apache.httpcomponents" % "httpclient" % "4.5.5",
      "org.apache.httpcomponents" % "httpcore" % "4.4.9",

      "org.asynchttpclient" % "async-http-client" % asyncHttpClientV,
      "org.bitbucket.b_c" % "jose4j" % joseV,
      "org.pac4j" % "pac4j-oidc" % pac4jV,
      "org.pac4j" %% "play-pac4j" % pac4jPlayV,
      "org.postgresql" % "postgresql" % postgresV,
      "org.scalaz" %% "scalaz-core" % scalazV,

      "com.typesafe.akka" %% "akka-testkit" % akkaV % Test,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % Test,
      "org.hsqldb" % "hsqldb" % hsqldbV % Test,
      "org.scalatest" %% "scalatest" % scalatestV % Test,
      "org.scalatestplus.play" %% "scalatestplus-play" % scalatestPlayV % Test*/
    //)

/*    libraryDependencies += guice,
    fork in Test := true,
    javaOptions in Test ++= Seq("-Dconfig.resource=test-application.conf"),
    routesGenerator := InjectedRoutesGenerator*/
  //)
  //.enablePlugins(PlayScala)
