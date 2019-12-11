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

    it("Exercice 3.3") {
      List.setHead(9, List(1, 2, 3, 4, 5)) should be (List(9, 2, 3, 4, 5))
    }

    it("Exercice 3.4") {
      List.drop(List(1, 2, 3, 4, 5), 3) should be (List(4, 5))
    }

    it("Exercice 3.5") {
      List.dropWhile(List("a", "b", "Haskell", "Scala", "Kotlin"), (s: String) => s.length < 7) should be (List("Haskell", "Scala", "Kotlin"))
      List.dropWhile(List("Haskell", "Scala", "a", "b", "Kotlin"), (s: String) => s.length > 5) should be (List("Scala", "a", "b", "Kotlin"))
    }
  }
}
