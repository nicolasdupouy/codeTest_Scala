package Chapter16

class InsertionSort {
  def isort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))
  }

  private def insert(x: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || x < xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)
  }
}
