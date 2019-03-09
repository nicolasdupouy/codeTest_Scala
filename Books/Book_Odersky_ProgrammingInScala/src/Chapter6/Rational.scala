package Chapter6

class Rational(n: Int, d: Int) {
  require(d != 0)

  private val greatCommonDivisor = gcd(n, d)
  val numerator: Int = n / greatCommonDivisor
  val denominator: Int = d / greatCommonDivisor

  // Auxiliary constructor
  def this(n: Int) = this(n, 1)

  override def toString: String = numerator + "/" + denominator

  def +(that: Rational): Rational =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  def +(i: Int): Rational =
    new Rational(
      numerator + i * denominator,
      denominator
    )

  def -(that: Rational): Rational =
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  def -(i: Int): Rational =
    new Rational(
      numerator - i * denominator,
      denominator
    )

  def *(that: Rational): Rational =
    new Rational(
      numerator * that.numerator,
      denominator * that.denominator
    )

  def *(i: Int): Rational =
    new Rational(
      i * numerator,
      denominator
    )

  def /(that: Rational): Rational =
    new Rational(
      numerator * that.denominator,
      denominator * that.numerator
    )

  def /(i: Int): Rational =
    new Rational(
      numerator,
      denominator * i
    )

  def <(that: Rational): Boolean =
    numerator * that.denominator < that.numerator * denominator

  def max(that: Rational): Rational =
    if (this < that) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
