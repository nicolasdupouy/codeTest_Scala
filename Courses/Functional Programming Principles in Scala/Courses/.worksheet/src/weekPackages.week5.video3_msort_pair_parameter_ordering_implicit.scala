package weekPackages.week5
import math.Ordering

object video3_msort_pair_parameter_ordering_implicit {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(599); 
  def msort[T](xs: List[T])(implicit order: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (xs, Nil) => xs
          case (Nil, ys) => ys
          case (x :: xs1, y :: ys1) =>
            if (order.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (first, second) = xs splitAt n
      merge(msort(first), msort(second))
    }
  };System.out.println("""msort: [T](xs: List[T])(implicit order: scala.math.Ordering[T])List[T]""");$skip(36); 


  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  val fruits = List("apple", "pineapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(17); val res$0 = 
  
  msort(nums);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(16); val res$1 = 
  msort(fruits);System.out.println("""res1: List[String] = """ + $show(res$1))}
}
