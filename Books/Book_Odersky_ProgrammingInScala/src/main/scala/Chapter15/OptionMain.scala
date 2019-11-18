package Chapter15

object OptionMain extends App {

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
  println(capitals get "France")
  println(capitals get "Japan")
  println(capitals get "North Pole")
  println()

  println(show(capitals get "France"))
  println(show(capitals get "Japan"))
  println(show(capitals get "North Pole"))

  private def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}
