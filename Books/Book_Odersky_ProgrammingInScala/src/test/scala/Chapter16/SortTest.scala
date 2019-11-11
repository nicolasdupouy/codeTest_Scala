package Chapter16

import org.scalatest.{FunSpec, Matchers}

class SortTest extends FunSpec with Matchers {

  val sort = new Sort

  describe("Test insertion sort") {
    it("should sort empty list") {
      sort.insertionSort(List()) should be (List())
    }

    it("should sort (1, 2, 3) in (1, 2, 3)") {
      sort.insertionSort(List(1, 2, 3)) should be (List(1, 2, 3))
    }

    it("should sort (5, 2, 1, 67, 4, 3) in (1, 2, 3, 4, 5, 67)") {
      sort.insertionSort(List(5, 2, 1, 67, 4, 3)) should be (List(1, 2, 3, 4, 5, 67))
    }
  }

  describe("Test merge sort") {
    it("should sort empty list") {
      sort.mergeSort((x: Int, y: Int) => x < y)(List()) should be (List())
    }

    it("should sort (1, 2, 3) in (1, 2, 3)") {
      sort.mergeSort((x: Int, y: Int) => x < y)(List(1, 2, 3)) should be (List(1, 2, 3))
    }

    it("should sort (5, 2, 1, 67, 4, 3) in (1, 2, 3, 4, 5, 67)") {
      sort.mergeSort((x: Int, y: Int) => x < y)(List(5, 2, 1, 67, 4, 3)) should be (List(1, 2, 3, 4, 5, 67))
    }
  }
}
