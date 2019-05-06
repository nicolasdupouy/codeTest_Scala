package Chapter10

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
  val height: Int = contents.length
  val width: Int = if (height == 0) 0 else contents(0).length
}
