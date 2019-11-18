package Chapter16

import org.scalatest.{FunSpec, Matchers}

class ZippingListsTest extends FunSpec with Matchers {

  val abcde = List('a', 'b', 'c', 'd', 'e')
  describe("[Test zip/unzip]") {
    it("") {
      abcde.indices zip abcde should be (Vector((0, 'a'), (1, 'b'), (2, 'c'), (3, 'd'), (4, 'e')))
      val zipped = abcde zip List(1, 2, 3)
      zipped should be(List(('a', 1), ('b', 2), ('c', 3)))

      abcde.zipWithIndex should be (List(('a', 0), ('b', 1), ('c', 2), ('d', 3), ('e', 4)))

      zipped.unzip should be ((List('a', 'b', 'c'), List(1, 2, 3)))
    }
  }

  describe("[Test zipped]") {
    it("Processing multiple lists together") {
      (List(10, 20), List(3, 4, 5)).zipped.map(_ * _) should be (List(30, 80))
    }
  }
}
