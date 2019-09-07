package Chapter15

import org.scalatest.{FlatSpec, Matchers}

class ExprTest extends FlatSpec with Matchers {
  it should "test sealed classes with pattern matching" in {
    describe(new Var("v"))
  }

  // @unchecked is to avoid warning as we know all patterns are not matched in the following pattern matching.
  private def describe(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
}
