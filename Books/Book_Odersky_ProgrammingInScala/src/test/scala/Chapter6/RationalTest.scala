package Chapter6

import org.scalatest.{FunSpec, Matchers}

class RationalTest extends FunSpec with Matchers {
  describe("Test Rational") {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)

    it("1/3 + 5/7 should be equal to 22/21") {
      val x = new Rational(1, 3)
      val y = new Rational(5, 7)

      x + y should be(new Rational(22, 21))
    }

    it("1/2 + 2/3 = 7/6") {
      oneHalf + twoThirds should be(new Rational(7, 6))
    }

    it("1/2 < 2/3 is true") {
      oneHalf < twoThirds should be(true)
    }

    it("max of 1/2 and 2/3 is 2/3") {
      oneHalf.max(twoThirds) should be(twoThirds)
    }

    it("Rational(3) = 3/1") {
      val rationalThree = new Rational(3)
      rationalThree.toString should be("3/1")
    }

    it("66/42 is equal to 11/7") {
      new Rational(66, 42) should be(new Rational(11, 7))
    }

    it("2/3 * 2 = 4/3") {
      val fourThirds = new Rational(4, 3)
      twoThirds * 2 should be (fourThirds)
    }
  }
}
