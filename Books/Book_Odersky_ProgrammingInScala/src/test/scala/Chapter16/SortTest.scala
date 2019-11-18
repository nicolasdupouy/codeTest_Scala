package Chapter16

import org.scalatest.{FunSpec, Matchers}

class SortTest extends FunSpec with Matchers {

  private val sort = new Sort
  private val intSort = sort.mergeSort((x: Int, y: Int) => x < y) _
  private val reverseIntSort = sort.mergeSort((x: Int, y: Int) => x > y) _
  private val intSortSwapped = sort.mergeSortSwapped[Int](_)(_ < _)
  private val reverseIntSortSwapped = sort.mergeSortSwapped[Int](_)(_ > _)

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
      intSort(List()) should be (List())
      intSortSwapped(List()) should be (List())
    }

    it("should sort (1, 2, 3) in (1, 2, 3)") {
      intSort(List(1, 2, 3)) should be (List(1, 2, 3))
      intSortSwapped(List(1, 2, 3)) should be (List(1, 2, 3))
    }

    it("should sort (5, 2, 1, 67, 4, 3) in (1, 2, 3, 4, 5, 67)") {
      intSort(List(5, 2, 1, 67, 4, 3)) should be (List(1, 2, 3, 4, 5, 67))
      intSortSwapped(List(5, 2, 1, 67, 4, 3)) should be (List(1, 2, 3, 4, 5, 67))
    }

    it("should reverse sort empty list") {
      reverseIntSort(List()) should be (List())
      reverseIntSortSwapped(List()) should be (List())
    }

    it("should reverse sort (1, 2, 3) in (3, 2, 1)") {
      reverseIntSort(List(1, 2, 3)) should be (List(3, 2, 1))
      reverseIntSortSwapped(List(1, 2, 3)) should be (List(3, 2, 1))
    }

    it("should reverse sort (5, 2, 1, 67, 4, 3) in (67, 5, 4, 3, 2, 1)") {
      reverseIntSort(List(5, 2, 1, 67, 4, 3)) should be (List(67, 5, 4, 3, 2, 1))
      reverseIntSortSwapped(List(5, 2, 1, 67, 4, 3)) should be (List(67, 5, 4, 3, 2, 1))
    }
  }
}
