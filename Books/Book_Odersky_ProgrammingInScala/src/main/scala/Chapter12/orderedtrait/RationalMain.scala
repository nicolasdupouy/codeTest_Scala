package Chapter12.orderedtrait

object RationalMain extends App {
  val half = new Rational(1, 2)
  val third = new Rational(1, 3)

  val secondHalf = new Rational(1, 2)

  println(s"1/2 < 1/3  is ${half < third}")
  println(s"1/2 <= 1/3 is ${half <= third}")
  println(s"1/2 > 1/3  is ${half > third}")
  println(s"1/2 >= 1/3 is ${half >= third}")
  println()
  println(s"1/2 > 1/2  is ${half > secondHalf}")
  println(s"1/2 >= 1/2 is ${half >= secondHalf}")
}
