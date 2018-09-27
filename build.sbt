import Dependencies._
import microsites._

enablePlugins(MicrositesPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "oscarvarto.github.io",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "learning-scala",
    micrositeName := "Learning Scala",
    micrositeDescription := "Notes on Scala",
    micrositeBaseUrl := "/learning-scala",
    micrositeDocumentationUrl := "/learning-scala/docs",
    micrositeAuthor := "Oscar Vargas Torres",
    micrositeHomepage := "https://oscarvarto.github.io/learning-scala/",
    micrositeTwitterCreator := "@oscarvarto",
    micrositeGithubOwner := "oscarvarto",
    micrositeGithubRepo := "learning-scala",
    micrositeGitterChannel := true,
    micrositeGitterChannelUrl := "IntersysConsulting/learning-scala",
    micrositeHighlightTheme := "color-brewer",
    micrositeHighlightLanguages ++= Seq("haskell", "fsharp", "cs", "python"),
    micrositeCDNDirectives := CdnDirectives(
      jsList = List(
        "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML,https://oscarvarto.github.io/learning-scala/js/mathjax-config.js"
      ),
      cssList = List(
        //"https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css"
      )
    ),
    libraryDependencies ++= Seq(
      atto,
      scalaTest % Test
    )
  )
