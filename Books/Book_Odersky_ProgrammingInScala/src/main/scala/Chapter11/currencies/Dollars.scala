package Chapter11.currencies

class Dollars(val amount: Int) extends AnyVal {
  override def toString: String = "$" + amount
}
