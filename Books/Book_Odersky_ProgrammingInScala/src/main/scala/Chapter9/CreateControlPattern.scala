package Chapter9

import java.io.{File, PrintWriter}

object CreateControlPattern extends App {
  private def withPrintWriter(file: File)(operation: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      operation(writer)
    }
    finally {
      writer.close()
    }
  }

  val file = new File("date.text")
  withPrintWriter(file) {
    writer => writer.println(new java.util.Date)
  }
}
