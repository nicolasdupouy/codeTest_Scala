package Chapter16

import org.scalatest.{FunSpec, Matchers}

class InsertionSortTest extends FunSpec with Matchers {

  val insertionSort = new InsertionSort

  describe("Test insertion sort") {
    it("should sort empty list") {
      insertionSort.isort(List()) should be (List())
    }

    it("should sort (1, 2, 3) in (1, 2, 3)") {
      insertionSort.isort(List(1, 2, 3)) should be (List(1, 2, 3))
    }

    it("should sort (5, 2, 1, 67, 4, 3) in (1, 2, 3, 4, 5, 67)") {
      insertionSort.isort(List(5, 2, 1, 67, 4, 3)) should be (List(1, 2, 3, 4, 5, 67))
    }
  }
}
