package Chapter7

import java.io.File

object Filter extends App {

  val files = new File("src/main/scala/Chapter6").listFiles
  val scalaFiles = getScalaFiles(files)
  scalaFiles.foreach(println)

  val greppedLines = grep(".*println.*")
  greppedLines.foreach(println)

  private def getScalaFiles(files: Array[File]): Array[File] = {
    for (
      file <- files
      if file.isFile
      if file.getName.endsWith(".scala")
    ) yield file
  }

  private def fileLines(file: File) =
    scala.io.Source.fromFile(file).getLines().toList

  private def grep(pattern: String) =
    for {
      file <- files
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } yield file + ":" + trimmed
}
