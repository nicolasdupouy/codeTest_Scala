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

  @annotation.tailrec
  def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

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

  def sumFoldLeft(ints: List[Int]): Int =
    foldLeft(ints, 0)(_ + _)

  def productFoldLeft(nums: List[Double]): Double =
    foldLeft(nums, 1.0)(_ * _)

  def lengthFoldLeft(l: List[Int]): Int =
    foldLeft(l, 0)((acc, _) => acc + 1)

  def reverse[A](l: List[A]): List[A] =
    foldLeft(l, Nil: List[A])((acc, h) => Cons(h, acc))

  def append[A](l1: List[A], l2: List[A]): List[A] =
    foldRight(l1, l2)(Cons(_, _))

  def concatenates[A](l: List[List[A]]): List[A] =
    foldLeft(l, Nil: List[A])(append)

  def mapAddOne(l: List[Int]): List[Int] =
    foldRight(l, Nil: List[Int])((h, t) => Cons(h + 1, t))

  def convertDoubleToString(l: List[Double]): List[String] =
    foldRight(l, Nil: List[String])((h, t) => Cons(h.toString, t))

  def map[A, B](l: List[A])(f: A => B): List[B] =
    foldRight(l, Nil: List[B])((h, t) => Cons(f(h), t))

  def filter[A](l: List[A])(f: A => Boolean): List[A] =
  //foldRight(l, Nil: List[A])((h, t) => if (f(h)) Cons(h, t) else t)
    flatMap(l)(x => if (f(x)) List(x) else Nil)

  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = {
    concatenates(map(l)(f))
    // OR
    //foldRight(l, Nil:List[B])((h, t) => append(f(h), t))
  }

  def zipIntLists(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
      case(Cons(h1, t1), Cons(h2, t2)) => Cons(h1+h2, zipIntLists(t1, t2))
  }

  def zipWith[A, B, C](l1: List[A], l2: List[B])(f: (A, B) => C): List[C] = (l1, l2) match {
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f))
  }

  @annotation.tailrec
  def startWith[A](l: List[A], prefix: List[A]): Boolean = (l, prefix) match {
    case (_, Nil) => true
    case (Cons(h1, t1), Cons(h2, t2)) if (h1 == h2) => startWith(t1, t2)
    case _ => false
  }

  @annotation.tailrec
  def hasSubSequence[A](l: List[A], subSequence: List[A]): Boolean = l match {
    case Nil => subSequence == Nil
    case _ if startWith(l, subSequence) => true
    case Cons(_, t) => hasSubSequence(t, subSequence)
  }
}
