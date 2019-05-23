package Chapter6

object RationalMain extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)

  val z = x + y

  println(s"z = $z")
  println()

  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)

  println(s"$oneHalf + $twoThirds = ${oneHalf + twoThirds}")
  println(s"$oneHalf < $twoThirds is ${oneHalf < twoThirds}")
  println(s"max of $oneHalf and $twoThirds is ${oneHalf.max(twoThirds)}")
  println()
  println(s"Rational(3) = ${new Rational(3)}")

  val sixtySixoverFortyTwo = new Rational(66, 42)
  println(s"66/42 = $sixtySixoverFortyTwo")
}
