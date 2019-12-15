package chapter3

import org.scalatest.{FunSpec, Matchers}

class TreeTest extends FunSpec with Matchers {
  val t1 = new Chapter3.Branch(
    new Chapter3.Leaf("a"),
    new Chapter3.Leaf("b"))
  val t2 = new Chapter3.Branch(
    new Chapter3.Leaf("a"),
    new Chapter3.Branch(
      new Chapter3.Leaf("b"),
      new Chapter3.Leaf("c")))
  val t3 = new Chapter3.Leaf(5)

  val t4 = new Chapter3.Branch(
    new Chapter3.Leaf(5),
    new Chapter3.Branch(
      new Chapter3.Leaf(8),
      new Chapter3.Leaf(1)))
  val t4_plus_5 = new Chapter3.Branch(
    new Chapter3.Leaf(10),
    new Chapter3.Branch(
      new Chapter3.Leaf(13),
      new Chapter3.Leaf(6)))

  describe("Test Tree") {
    it("Exercice 3.25") {
      Chapter3.Tree.size(t1) should be(3)
      Chapter3.Tree.size(t2) should be(5)
      Chapter3.Tree.size(t3) should be(1)
    }

    it("Exercice 3.26") {
      Chapter3.Tree.maximum(t3) should be(5)
      Chapter3.Tree.maximum(t4) should be(8)
    }

    it("Exercice 3.27") {
      Chapter3.Tree.depth(t3) should be (1)
      Chapter3.Tree.depth(t4) should be (3)
    }

    it("Exercice 3.28") {
      Chapter3.Tree.map(t4)(_ + 5) should be (t4_plus_5)
    }

    it("Exercice 3.29") {
      Chapter3.Tree.sizeWithFold(t1) should be(3)
      Chapter3.Tree.sizeWithFold(t2) should be(5)
      Chapter3.Tree.sizeWithFold(t3) should be(1)

      Chapter3.Tree.maximumWithFold(t3) should be(5)
      Chapter3.Tree.maximumWithFold(t4) should be(8)

      Chapter3.Tree.depthWithFold(t3) should be (1)
      Chapter3.Tree.depthWithFold(t4) should be (3)

      Chapter3.Tree.mapWithFold(t4)(_ + 5) should be (t4_plus_5)
    }

  }
}
