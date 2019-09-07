package Chapter15

// sealed garantees that all subclass are located in the same file.
// It is usefull for pattern matching.
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(name: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  object Expr {
    // @unchecked is to avoid warning as we know all patterns are not matched in the following pattern matching.
    def describe(e: Expr): String = (e: @unchecked) match {
      case Number(_) => "a number"
      case Var(_) => "a variable"
    }
  }