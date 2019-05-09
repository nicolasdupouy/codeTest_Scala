package Chapter10

class LineElement(s: String) extends Element {
  override val contents = Array(s)
  override val width: Int = s.length
  override val height: Int = 1
}
