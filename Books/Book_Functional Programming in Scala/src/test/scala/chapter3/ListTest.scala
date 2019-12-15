package chapter3

import org.scalatest.{FunSpec, Matchers}

class ListTest extends FunSpec with Matchers {
  describe("Test List") {
    it("sum of List(1, 2, 3, 4) should be 10") {
      val list123 = Chapter3.List(1, 2, 3, 4)
      Chapter3.List.sum(list123) should be(10)
    }

    it("product of List(1, 2, 3, 4) should be 24") {
      val list123 = Chapter3.List(1.0, 2.0, 3.0, 4.0)
      Chapter3.List.product(list123) should be(24.0)
    }
  }

  describe("Exercices") {
    it("Exercice 3.1") {
      val x: Int = Chapter3.List(1, 2, 3, 4, 5) match {
        case Chapter3.Cons(x, Chapter3.Cons(2, Chapter3.Cons(4, _))) => x
        case Chapter3.Nil => 42
        case Chapter3.Cons(x, Chapter3.Cons(y, Chapter3.Cons(3, Chapter3.Cons(4, _)))) => x + y
        case _ => 101
      }
      println(s"x = $x")
    }

    it("Exercice 3.2") {
      Chapter3.List.tail(Chapter3.List(1, 2, 3, 4, 5)) should be(Chapter3.List(2, 3, 4, 5))
    }

    it("Exercice 3.3") {
      Chapter3.List.setHead(9, Chapter3.List(1, 2, 3, 4, 5)) should be(Chapter3.List(9, 2, 3, 4, 5))
    }

    it("Exercice 3.4") {
      Chapter3.List.drop(Chapter3.List(1, 2, 3, 4, 5), 3) should be(Chapter3.List(4, 5))
    }

    it("Exercice 3.5") {
      Chapter3.List.dropWhile(Chapter3.List("a", "b", "Haskell", "Scala", "Kotlin"), (s: String) => s.length < 7) should be(Chapter3.List("Haskell", "Scala", "Kotlin"))
      Chapter3.List.dropWhile(Chapter3.List("Haskell", "Scala", "a", "b", "Kotlin"), (s: String) => s.length > 5) should be(Chapter3.List("Scala", "a", "b", "Kotlin"))
    }

    it("Exercice 3.6") {
      Chapter3.List.init(Chapter3.List(1, 2, 3, 4)) should be(Chapter3.List(1, 2, 3))
    }

    it("Exercice 3.7") {
      Chapter3.List.product(Chapter3.List(1, 2, 3, 4)) should be(24.0)
      Chapter3.List.productFoldRight(Chapter3.List(1, 2, 3, 4)) should be(24.0)
      // Not possible
      //Chapter3.List.productFoldRightShortCircuit(Chapter3.List(1, 2, 3, 4)) should be (24.0)
    }

    it("Exercice 3.9") {
      Chapter3.List.length(Chapter3.List(1, 2, 3, 4)) should be(4)
    }

    it("Exercice 3.10 and 3.11") {
      Chapter3.List.sumFoldLeft(Chapter3.List(1, 2, 3, 4)) should be(10)
      Chapter3.List.productFoldLeft(Chapter3.List(1, 2, 3, 4)) should be(24.0)
      Chapter3.List.lengthFoldLeft(Chapter3.List(1, 2, 3, 4)) should be(4)
    }

    it("Exercice 3.12") {
      Chapter3.List.reverse(Chapter3.List(1, 2, 3)) should be(Chapter3.List(3, 2, 1))
    }

    it("Exercice 3.14") {
      Chapter3.List.append(Chapter3.List(1, 2, 3), Chapter3.List(4, 5, 6)) should be(Chapter3.List(1, 2, 3, 4, 5, 6))
    }

    it("Exercice 3.15") {
      Chapter3.List.concatenates(Chapter3.List(Chapter3.List(1, 2, 3), Chapter3.List(4, 5, 6), Chapter3.List(7, 8, 9))) should be(Chapter3.List(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    it("Exercice 3.16") {
      Chapter3.List.mapAddOne(Chapter3.List(1, 2, 3)) should be(Chapter3.List(2, 3, 4))
    }

    it("Exercice 3.17") {
      Chapter3.List.convertDoubleToString(Chapter3.List(1.2, 3.0)) should be(Chapter3.List("1.2", "3.0"))
    }

    it("Exercice 3.18") {
      Chapter3.List.map(Chapter3.List(1, 2, 3))(_ + 1) should be(Chapter3.List(2, 3, 4))
      Chapter3.List.map(Chapter3.List(1.2, 3.0))(_.toString) should be(Chapter3.List("1.2", "3.0"))
    }

    it("Exercice 3.19 and Exercice 3.21") {
      Chapter3.List.filter(Chapter3.List(2, 3, 4, 5, 6))(_ % 2 == 0) should be(Chapter3.List(2, 4, 6))
    }

    it("Exercice 3.20") {
      Chapter3.List.flatMap(Chapter3.List(1, 2, 3))(i => Chapter3.List(i, i)) should be(Chapter3.List(1, 1, 2, 2, 3, 3))
    }

    it("Exercice 3.22") {
      Chapter3.List.zipIntLists(Chapter3.List(1, 2, 3), Chapter3.List(4, 5, 6)) should be(Chapter3.List(5, 7, 9))
    }

    it("Exercice 3.23") {
      Chapter3.List.zipWith(Chapter3.List(1, 2, 3), Chapter3.List(4, 5, 6))(_ + _) should be(Chapter3.List(5, 7, 9))
    }

    it("Exercice 3.24") {
      Chapter3.List.hasSubSequence(Chapter3.List(1, 2, 3, 4), Chapter3.List(2, 3)) should be(true)
      Chapter3.List.hasSubSequence(Chapter3.List(1, 2, 3, 4), Chapter3.List(2, 5)) should be(false)
    }
  }
}
