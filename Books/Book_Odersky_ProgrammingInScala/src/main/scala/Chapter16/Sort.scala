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
}
