package Chapter7

import java.io.File

object Filter extends App {

  val files = new File("Books/Book_Odersky_ProgrammingInScala/src/Chapter6").listFiles
  val scalaFiles = getScalaFiles(files)
  scalaFiles.foreach(println)

  private def getScalaFiles(files: Array[File]): Array[File] = {
    for (
      file <- files
      if file.isFile
      if file.getName.endsWith(".scala")
    ) yield file
  }
}
