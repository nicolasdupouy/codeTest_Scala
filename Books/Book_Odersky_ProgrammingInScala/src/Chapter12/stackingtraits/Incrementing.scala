package Chapter12.stackingtraits

trait Incrementing extends IntQueue {
  abstract override def put(n: Int): Unit = super.put(n + 1)
}
