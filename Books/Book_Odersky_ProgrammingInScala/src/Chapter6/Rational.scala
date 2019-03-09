package Chapter6

class Rational(n: Int, d: Int) {
  require(d != 0)

  private val greatCommonDivisor = gcd(n, d)
  val numerator: Int = n / greatCommonDivisor
  val denominator: Int = d / greatCommonDivisor

  // Auxiliary constructor
  def this(n: Int) = this(n, 1)

  override def toString: String = numerator + "/" + denominator

  def add(that: Rational): Rational =
    new Rational(
      n * that.denominator + that.numerator * d,
      d * that.denominator
    )

  def lessThan(that: Rational): Boolean =
    this.numerator * that.denominator < that.numerator * this.denominator

  def max(that: Rational): Rational =
    if (this lessThan that) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
