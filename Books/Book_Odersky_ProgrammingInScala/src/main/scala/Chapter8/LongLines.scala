package Chapter8

import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for(line <- source.getLines())
      processLine(line)

    def processLine(line: String) = {
      if (line.length > width)
        println(filename + " " + line.trim)
    }
  }
}
