package Chapter10

import Chapter10.Element.makeElement

abstract class Element {
  def contents: Array[String]

  override def toString: String = contents mkString "\n"

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

  def above(that: Element) =
    makeElement(this.contents ++ that.contents)

  def beside(that: Element) =
    makeElement(
      for ((line1, line2) <- this.contents zip that.contents)
        yield line1 + line2
    )
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
