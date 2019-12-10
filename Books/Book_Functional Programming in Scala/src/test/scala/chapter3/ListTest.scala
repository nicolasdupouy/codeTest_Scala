package chapter3

import Chapter3.{List, Cons, Nil}
import org.scalatest.{FunSpec, Matchers}

class ListTest extends FunSpec with Matchers {
  describe("Test List") {
    it("sum of List(1, 2, 3, 4) should be 10") {
      val list123 = List(1, 2, 3, 4)
      List.sum(list123) should be(10)
    }

    it("product of List(1, 2, 3, 4) should be 24") {
      val list123 = List(1, 2, 3, 4)
      List.product(list123) should be(24)
    }
  }

  describe("Exercices") {
    it("Exercice 3.1") {
      val x = List(1, 2, 3, 4, 5) match {
        case Cons(x, Cons(2, Cons(4, _))) => x
        case Nil => 42
        case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
        case _ => 101
      }
      println(s"x = $x")
    }

    it("Exercice 3.2") {
      List.tail(List(1, 2, 3, 4, 5)) should be (List(2, 3, 4, 5))
    }
  }
}
