name := "easymda_generated"

organization := "EasyMda"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions := Seq("-encoding", "utf8",
                     "-target:jvm-1.6",
                     "-feature",
                     "-language:implicitConversions",
                     "-language:postfixOps",
                     "-unchecked",
                     // "-deprecation",
                     "-Xlog-reflective-calls"
                    )

mainClass := Some("flca.demo.DemoMain")

// scalaSource in Compile := baseDirectory.value / "src-gen"

// scalaSource in Test := baseDirectory.value / "src-gen-test"

// resourceDirectory in Compile := baseDirectory.value / "src/main/resources"

unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
  Seq(
    base / "src-gen",
    base / "src-gen-test", 
    base / "src/main/resources"
  )
}

resolvers ++= Seq("Sonatype Releases"   at "http://oss.sonatype.org/content/repositories/releases",
                  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
                  "Spray Repository"    at "http://repo.spray.io/",
                  "Spray Nightlies"     at "http://nightlies.spray.io/",
                  "Base64 Repo"         at "http://dl.bintray.com/content/softprops/maven"             )

libraryDependencies ++= {
  val akkaVersion  = "2.3.1"
  val sprayVersion = "1.3.1"
  Seq(
    "com.typesafe.akka"       %%  "akka-actor"             % akkaVersion,
    "com.typesafe.akka"       %%  "akka-slf4j"             % akkaVersion,
    "io.spray"                %   "spray-caching"          % sprayVersion,
    "io.spray"                %   "spray-can"              % sprayVersion,
    "io.spray"                %   "spray-client"           % sprayVersion,
    "io.spray"                %   "spray-routing"          % sprayVersion,
    "io.spray"                %%  "spray-json"             % "1.2.5",
    "io.spray"                %   "spray-testkit"          % sprayVersion ,
    "me.lessis"               %%  "base64"                 % "0.1.0",
    "com.github.nscala-time"  %%  "nscala-time"            % "0.4.2",
    "ch.qos.logback"          %   "logback-classic"        % "1.0.12",
    "com.typesafe.akka"       %%  "akka-testkit"           % akkaVersion,
    "org.specs2"              %%  "specs2"                 % "2.1.1"   ,
    "com.typesafe.slick"     %% "slick"                         % "2.0.0",
      "org.slf4j"             % "slf4j-nop"                     % "1.6.4",
      "com.h2database"         % "h2"                             % "1.3.170",
      "org.xerial"             % "sqlite-jdbc"                 % "3.7.2",
      "com.jolbox"             % "bonecp"                     % "0.7.1.RELEASE",
      "org.scalatest"         % "scalatest_2.10"                 % "2.0"  ,
      "junit"                 % "junit"                         % "4.10"  ,
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.2.2",
    "org.apache.commons" % "commons-lang3" % "3.1",
    "org.json4s"    %% "json4s-native"   % "3.2.6"    
  )
}

