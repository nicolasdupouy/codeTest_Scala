package Chapter16

import org.scalatest.{FunSpec, Matchers}

class TabulatingListTest extends FunSpec with Matchers {

  describe("[Test tabulate]") {
    it("should create square list") {
      val square = List.tabulate(5)(n => n * n)
      square should be(List(0, 1, 4, 9, 16))
    }
  }
}
