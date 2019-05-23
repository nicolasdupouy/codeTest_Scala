package Chapter12.stackingtraits

trait Doubling extends IntQueue {
  abstract override def put(n: Int): Unit = super.put(n * 2)
}
