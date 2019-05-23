package Chapter12.stackingtraits

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buffer = new ArrayBuffer[Int]
  override def get(): Int = buffer.remove(0)
  override def put(n: Int): Unit = buffer += n
}
