package Chapter10

object ElementMain extends App {

  val e1: Element = new ArrayElement(Array("hello", "friend"))
  val e2: Element = new LineElement("Hello")
  val e3: Element = new UniformElement('x', 20, 3)


  val eAbove = e1 above e2
  val eBeside = e1 beside e2

  println(s"e3(contents = ${e3.contents(0)}, width = ${e3.width}, height = ${e3.height}")
}
