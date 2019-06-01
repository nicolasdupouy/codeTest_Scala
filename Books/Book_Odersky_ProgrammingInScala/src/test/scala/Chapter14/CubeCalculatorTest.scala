package Chapter14

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class CubeCalculatorTest extends FunSuite {
  test("CubeCalculator.cube") {
    assert(CubeCalculator.cube(3) === 27)
  }
}
