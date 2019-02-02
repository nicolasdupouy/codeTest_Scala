package Chapter3

import scala.io.Source

// Program arguments: Books/Book_Odersky_ProgrammingInScala/src/Chapter3/ReadFile.scala
object ReadFile extends App {
  if (args.length > 0) {

    val lines = Source.fromFile(args(0)).getLines().toList
    val maxWidth = maxLength(lines)

    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length + " | " + line)
    }
  }
  else
    Console.err.println("Please enter filename")


  def widthOfLength(s: String) = s.length.toString.length

  def maxLength(lines: List[String]): Int = {
    var maxWidth = 0
    for (line <- lines)
      maxWidth = maxWidth.max(widthOfLength(line))

    return maxWidth
  }
}
