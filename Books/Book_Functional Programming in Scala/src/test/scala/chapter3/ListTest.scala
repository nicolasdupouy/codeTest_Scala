package chapter3

import org.scalatest.{FunSpec, Matchers}

class ListTest extends FunSpec with Matchers {
  describe("Test List") {
    it("sum of List(1, 2, 3, 4) should be 10") {
      val list123 = Chapter3.List(1, 2, 3, 4)
      Chapter3.List.sum(list123) should be(10)
    }

    it("product of List(1, 2, 3, 4) should be 24") {
      val list123 = Chapter3.List(1, 2, 3, 4)
      Chapter3.List.product(list123) should be(24)
    }
  }
}
