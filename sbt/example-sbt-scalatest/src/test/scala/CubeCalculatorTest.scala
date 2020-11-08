import org.scalatest.FunSuite

class CubeCalculatorTest extends FunSuite {
  test("CubeCalculator.cube") {
    assert(CubeCalculator.cube(4) === 64)
    assert(CubeCalculator.cube(0) === 0)
  }
}