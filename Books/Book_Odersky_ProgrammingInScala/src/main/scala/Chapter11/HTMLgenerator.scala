package Chapter11

object HTMLgenerator extends App {

  class Anchor(val value: String) extends AnyVal
  class Style(val value: String) extends AnyVal
  class Text(val value: String) extends AnyVal
  class Html(val value: String) extends AnyVal

  def titleWithString(text: String, anchor: String, style: String) =
    s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

  def titleWithStrongValueTypes(text: Text, anchor: Anchor, style: Style): Html =
    new Html(
      s"<a id='${anchor.value}'><h1 class='${style.value}'>${text.value}</h1></a>"
    )

  val titleStringKo = titleWithString("chap:vcls", "bold", "Value Classes")
  val titleStringOk = titleWithString("Value Classes", "chap:vcls", "bold")
  println(s"titleWithString KO = $titleStringKo")
  println(s"titleWithString OK = $titleStringOk")

  val titleValueTypesOk = titleWithStrongValueTypes(new Text("Value Classes"), new Anchor("chap:vcls"), new Style("bold"))
  println(s"titleValueTypes = ${titleValueTypesOk.value}")
}
