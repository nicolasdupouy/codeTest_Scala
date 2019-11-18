package Chapter16

import org.scalatest.{FunSpec, Matchers}

class HighOrderMethodsOnClassListTest extends FunSpec with Matchers {
  val highOrderMethodsOnClassList = new HighOrderMethodsOnClassList

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

  describe("[Test partition]") {
    it("should split (1, 2, 3, 4, 5) in a pair of 2 lists (2, 4) and (1, 3, 5) => xs partition p : (xs filter p, xs filter (!p(_)))") {
      val result = List(1, 2, 3, 4, 5) partition (_ % 2 == 0)
      val expectedResult = (List(2, 4), List(1, 3, 5))
      result should be(expectedResult)
    }
  }

  describe("[Test find]") {
    it("should find the first pair element (returns Option[T]") {
      List(1, 2, 3, 4, 5) find (_ % 2 == 0) should be (Some(2))
    }
    it ("should find nothing") {
      List(1, 2, 3, 4, 5) find (_ <= 0) should be (None)
    }
  }

  describe("[Test takeWhile, dropWhile and span]") {
    it("takeWhile") {
      List(1, 2, 3, -4, 5) takeWhile(_ > 0) should be (List(1, 2, 3))
    }

    it("dropWhile") {
      words dropWhile(_ startsWith "t") should be (List("quick", "brown", "fox"))
    }

    it("span => xs span p : (xs takeWhile p, xs dropWhile p)") {
      List(1, 2, 3, -4, 5) span (_ > 0) should be (List(1, 2, 3), List(-4, 5))
    }
  }

  describe("[Test Folding lists /: and :\\ ]") {
    it ("foldLeft => /:") {
      highOrderMethodsOnClassList.sumShortSyntax(List(1, 2, 3, 4, 5)) should be (15)
      highOrderMethodsOnClassList.sumLongSyntax(List(1, 2, 3, 4, 5)) should be (15)

      highOrderMethodsOnClassList.productShortSyntax(List(1, 2, 3, 4, 5)) should be (120)
      highOrderMethodsOnClassList.productLongSyntax(List(1, 2, 3, 4, 5)) should be (120)

      highOrderMethodsOnClassList.flattenLeftShortSyntax(List(List(1, 2, 3), List(2, 3, 4))) should be (List(1, 2, 3, 2, 3, 4))
      highOrderMethodsOnClassList.flattenLeftLongSyntax(List(List(1, 2, 3), List(2, 3, 4))) should be (List(1, 2, 3, 2, 3, 4))

      highOrderMethodsOnClassList.reverseFoldLeftShortSyntax(List(1, 2, 3, 4, 5)) should be (List(5, 4, 3, 2, 1))
      highOrderMethodsOnClassList.reverseFoldLeftLongSyntax(List(1, 2, 3, 4, 5)) should be (List(5, 4, 3, 2, 1))
    }

    it ("foldRight => :\\") {
      highOrderMethodsOnClassList.flattenRightShortSyntax(List(List(1, 2, 3), List(2, 3, 4))) should be (List(1, 2, 3, 2, 3, 4))
      highOrderMethodsOnClassList.flattenRightLongSyntax(List(List(1, 2, 3), List(2, 3, 4))) should be (List(1, 2, 3, 2, 3, 4))
    }
  }
}
