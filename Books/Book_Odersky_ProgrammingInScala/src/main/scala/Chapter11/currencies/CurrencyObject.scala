package Chapter11.currencies

object CurrencyObject extends App {
  val d = new Dollars(1000)
  val sf = new SwissFrancs(1000)

  println(s"1000 dollars      : $d")
  println(s"1000 swiss frands : $sf")
}
