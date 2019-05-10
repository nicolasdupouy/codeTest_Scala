package Chapter10

import Chapter10.Element.makeElement

abstract class Element {
  def contents: Array[String]

  /* Page 186: The 2 followings can be define as parameterless methods (def) or fields (val)
       It is equivalent from a caller's point of view.
       The only difference is that field accesses might be slightly faster than method invocations bacause
       the field values are pre-computed when the class is initialized, instead of being computed on each method call.
    */
  /* Also, by convention (page 187):
    It is encouraged in Scala to define methods that take no parameters and have no side effects as parameterless methods
    (i.e., leaving off the empty parentheses).
    On the other hand, you should never define a method that has side-effects without parentheses,
    because invocations of that method would then look like a field selection.
    So your clients might be surprised to see side effects.
   */
  // Nota Bene: Use "val" for height and width here is dangerous because it uses an undefined "contents"
  def height: Int = contents.length

  def width: Int =
    if (height == 0) 0 else contents(0).length

  def above(that: Element) = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    makeElement(this1.contents ++ that1.contents)
  }

  def beside(that: Element) = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    makeElement(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
  }

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = makeElement(' ', (w - width) / 2, height)
      val right = makeElement(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = makeElement(' ', width, (h - height) / 2)
      val bottom = makeElement(' ', width, h - height - top.height)
      top above this above bottom
    }

  override def toString: String = contents mkString "\n"
}

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    override val contents = Array(s)
    override val width: Int = s.length
    override val height: Int = 1
  }

  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends Element {
    private val line = ch.toString * width
    override def contents = Array.fill(height)(line)
  }

  def makeElement(contents: Array[String]): Element =
    new ArrayElement(contents)

  def makeElement(ch: Char, width: Int, height: Int): Element =
    new UniformElement(ch, width, height)

  def makeElement(line: String): Element =
    new LineElement(line)
}
