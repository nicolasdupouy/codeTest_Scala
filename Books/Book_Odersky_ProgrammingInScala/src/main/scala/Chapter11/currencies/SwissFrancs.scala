package Chapter11.currencies

class SwissFrancs(val amount: Int) extends AnyVal {
  override def toString: String = amount + " CHF"
}
