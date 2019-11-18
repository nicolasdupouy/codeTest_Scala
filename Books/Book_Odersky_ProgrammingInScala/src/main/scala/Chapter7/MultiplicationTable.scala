package Chapter7

object MultiplicationTable extends App {

  val mt = multiplicationTable()
  println(mt)


  def multiplicationTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val product = (row * col).toString
      val padding = " " * (4 - product.length)
      padding + product
    }
}
