package Chapter7

import java.io.File
import scala.collection.mutable.Set

object Filter extends App {

  val files = new File("Books/Book_Odersky_ProgrammingInScala/src/Chapter6").listFiles
  val scalaFiles = getScalaFiles(files)
  scalaFiles.foreach(println)

  private def getScalaFiles(files: Array[File]): Set[File] = {
    val allFiles = Set[File]()
    for (
      file <- files
      if file.isFile
      if file.getName.endsWith(".scala")
    ) allFiles += file

    allFiles
  }
}
