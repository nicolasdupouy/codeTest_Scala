package Chapter3

import scala.io.Source

// Program arguments: Books/Book_Odersky_ProgrammingInScala/src/Chapter3/ReadFile.scala
object ReadFile extends App {
  if (args.length > 0) {
    for (line <- Source.fromFile(args(0)).getLines())
      println(line.length + " " + line)
  }
  else
    Console.err.println("Please enter filename")
}
