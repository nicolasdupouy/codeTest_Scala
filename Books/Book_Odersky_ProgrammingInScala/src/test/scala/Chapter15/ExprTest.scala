package Chapter15

import org.scalatest.{FlatSpec, Matchers}

class ExprTest extends FlatSpec with Matchers {
  it should "test sealed classes with pattern matching" in {
    Expr.describe(Var("v"))
  }
}
