package Chapter16

class HighOrderMethodsOnClassList {
  def sumShortSyntax(xs: List[Int]): Int = (0 /: xs)(_ + _)

  def sumLongSyntax(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)


  def productShortSyntax(xs: List[Int]): Int = (1 /: xs)(_ * _)

  def productLongSyntax(xs: List[Int]): Int = xs.foldLeft(1)(_ * _)


  def flattenLeftShortSyntax[T](xs: List[List[T]]): List[T] = (List[T]() /: xs)(_ ::: _)

  def flattenLeftLongSyntax[T](xs: List[List[T]]): List[T] = xs.foldLeft(List[T]())(_ ::: _)

  def flattenRightShortSyntax[T](xs: List[List[T]]): List[T] = (xs :\ List[T]())(_ ::: _)
  def flattenRightLongSyntax[T](xs: List[List[T]]): List[T] = xs.foldRight(List[T]())(_ ::: _)


  def reverseFoldLeftShortSyntax[T](xs: List[T]): List[T] = (List[T]() /: xs)({(ys, y) => y :: ys})

  def reverseFoldLeftLongSyntax[T](xs: List[T]): List[T] = xs.foldLeft(List[T]())({(ys, y) => y :: ys})
}
