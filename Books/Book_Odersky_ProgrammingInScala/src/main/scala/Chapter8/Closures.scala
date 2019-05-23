package Chapter8

object Closures extends App {

  private def makeIncrease(more: Int) = (x: Int) => x + more

  val inc1 = makeIncrease(1)
  val inc999 = makeIncrease(999)

  println(s"inc1(2) = ${inc1(2)}")
  println(s"inc1(5) = ${inc1(5)}")
  println()
  println(s"inc999(2) = ${inc999(2)}")
  println(s"inc999(5) = ${inc999(5)}")
}
