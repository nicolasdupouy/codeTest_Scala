package Chapter16

class Sort {
  def insertionSort(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => insert(y, insertionSort(ys))
  }

  private def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => List(x)
    case y :: ys => if (x <= y) x :: xs
                    else y :: insert(x, ys)
  }

  def mergeSortSwapped[T](xs: List[T])(less: (T, T) => Boolean): List[T] =
    mergeSort(less)(xs)

  def mergeSort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x,y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (left, right) = xs splitAt n
      merge(mergeSort(less)(left), mergeSort(less)(right))
    }
  }
}
