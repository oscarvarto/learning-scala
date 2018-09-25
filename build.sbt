import Dependencies._
import microsites._

enablePlugins(MicrositesPlugin)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "oscarvarto.github.io",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "learning-scala",
    micrositeName := "Learning Scala",
    micrositeDescription := "Notes on Scala",
    micrositeBaseUrl := "/learning-scala",
    micrositeAuthor := "Oscar Vargas Torres",
    micrositeHomepage := "https://oscarvarto.github.io/learning-scala/",
    micrositeTwitterCreator := "@oscarvarto",
    micrositeGithubOwner := "oscarvarto",
    micrositeGithubRepo := "learning-scala",
    micrositeGitterChannel := true,
    //micrositeGitterChannelUrl := "oscarvarto/learning-scala",
    micrositeHighlightTheme := "monokai",
    micrositeHighlightLanguages ++= Seq("haskell", "fsharp", "cs", "python"),
    micrositeCDNDirectives := CdnDirectives(
      jsList = List(
        //"https://cdnjs.cloudflare.com/ajax/libs/ag-grid/7.0.2/ag-grid.min.js"
        "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML,http://127.0.0.1:4000/learning-scala/js/mathjax-config.js"
      ),
      cssList = List(
        //"https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css"
      )
    ),
    libraryDependencies += scalaTest % Test
  )
