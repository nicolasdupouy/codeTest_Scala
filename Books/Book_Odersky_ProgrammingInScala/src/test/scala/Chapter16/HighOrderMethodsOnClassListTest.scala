package Chapter16

import org.scalatest.{FunSpec, Matchers}

class HighOrderMethodsOnClassListTest extends FunSpec with Matchers {
  val words = List("the", "quick", "brown", "fox")

  describe("[Test map]") {
    it("map(_ + 1) should map (1, 2, 3) to (2, 3, 4)") {
      List(1, 2, 3) map (_ + 1) should be (List(2, 3, 4))
    }

    it("map(_.length) should map List(\"the\", \"quick\", \"brown\", \"fox\") to List(3, 5, 5, 3)") {
      words map (_.length) should be (List(3, 5, 5, 3))
    }

    it("should map a list of words") {
      val result = words map (_.toList)
      val expectedResult = List(List('t', 'h', 'e'), List('q', 'u', 'i', 'c', 'k'), List('b', 'r', 'o', 'w', 'n'), List('f', 'o', 'x'))
      result should be (expectedResult)
    }
  }

  describe("[Test flatMap]") {
    it("should flatMap a list of words") {
      val result = words flatMap (_.toList)
      val expectedResult = List('t', 'h', 'e', 'q', 'u', 'i', 'c', 'k', 'b', 'r', 'o', 'w', 'n', 'f', 'o', 'x')
      result should be (expectedResult)
    }

    it("constructs a list of all pairs") {
      val result = List.range(1, 5) flatMap (
        i => List.range(1, i) map (j => (i, j))
      )
      val expectedResult = List((2, 1), (3, 1), (3, 2), (4, 1), (4, 2), (4, 3))
      result should be (expectedResult)
    }
  }
}
