package Chapter6

object RationalMain extends App {
  val x = new Rational(1 , 3)
  val y = new Rational(5, 7)

  val z1 = x.add(y)
  val z2 = x add y

  println("z1 = " + z1)
  println("z2 = " + z2)

  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)

  val oneHalfPlusTwoThirds = oneHalf add twoThirds
  println(oneHalfPlusTwoThirds)

  println(s"$oneHalf is less than $twoThirds is ${oneHalf.lessThan(twoThirds)}")
  println(s"max of $oneHalf and $twoThirds is ${oneHalf.max(twoThirds)}")

  println(s"Rational(3) = ${new Rational(3)}")
}
