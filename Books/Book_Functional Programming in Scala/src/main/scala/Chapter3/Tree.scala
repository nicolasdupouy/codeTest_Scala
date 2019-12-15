package Chapter3

sealed trait Tree[A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(n) => n
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(n) => Leaf(f(n))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  def fold[A, B](t: Tree[A])(lF: A => B)(bF: (B, B) => B): B = t match {
    case Leaf(n) => lF(n)
    case Branch(l, r) => bF(fold(l)(lF)(bF), fold(r)(lF)(bF))
  }

  def sizeWithFold[A](t: Tree[A]): Int =
    fold(t)(_ => 1)(1 + _ + _)

  def maximumWithFold(t: Tree[Int]): Int =
    fold(t)(n => n)(_ max _)

  def depthWithFold[A](t: Tree[A]): Int =
    fold(t)(_ => 1)((dl, dr) => 1 + (dl max dr))

  def mapWithFold[A, B](t: Tree[A])(f: A => B): Tree[B] =
    fold(t)(n => Leaf(f(n)):Tree[B])(Branch(_, _))
}