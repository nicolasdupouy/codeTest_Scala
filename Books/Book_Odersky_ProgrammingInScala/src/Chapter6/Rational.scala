package Chapter6

class Rational(n: Int, d: Int) {
  require(d != 0)
  val numerator: Int = n
  val denominator: Int = d

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
}
