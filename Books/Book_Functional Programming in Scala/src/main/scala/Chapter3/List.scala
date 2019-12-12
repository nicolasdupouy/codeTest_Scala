package Chapter3

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }

  def product(ints: List[Double]): Double = ints match {
    case Nil => 1.0
    case Cons(0, _) => 0.0
    case Cons(h, t) => h * product(t)
  }


  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(h, t) => f(h, foldRight(t, z)(f))
    }

  def productFoldRight(nums: List[Double]): Double =
    foldRight(nums, 1.0)(_ * _)

  def tail(l: List[Int]): List[Int] = l match {
    case Nil => throw new MatchError("Empty list has no tail")
    case Cons(_, t) => t
  }

  def setHead[A](a: A, l: List[A]): List[A] = l match {
    case Nil => throw new MatchError(("set head on empty list"))
    case Cons(_, t) => Cons(a, t)
  }

  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0)
      l
    else
      l match {
        case Nil => l
        case Cons(_, t) => drop(t, n - 1)
      }

  def dropWhile[A](l: List[A], p: A => Boolean): List[A] = l match {
    case Nil => l
    case Cons(h, t) if p(h) => dropWhile(t, p)
    case _ => l
  }

  def init[A](l: List[A]): List[A] = l match {
    case Nil => throw new MatchError("Empty list")
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  def length(l: List[Int]) =
    foldRight(l, 0)((_, acc) => acc + 1)
}
