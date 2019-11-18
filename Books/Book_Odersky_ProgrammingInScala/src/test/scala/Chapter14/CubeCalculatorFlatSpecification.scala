package Chapter14

import org.scalatest.{FlatSpec, Matchers}

class CubeCalculatorFlatSpecification extends FlatSpec with Matchers {
  "The cube computation" should "result in 27 for 3" in {
    CubeCalculator.cube(3) should be (27)
  }

  it should "not compute a result different of 27 for 3" in {
    CubeCalculator.cube(3) should not be (35)
  }
}
