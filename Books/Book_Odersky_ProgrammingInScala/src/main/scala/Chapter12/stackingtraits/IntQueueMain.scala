package Chapter12.stackingtraits

object IntQueueMain extends App {
  val basicIntQueue = new BasicIntQueue
  basicIntQueue.put(1)
  basicIntQueue.put(2)
  println(s"[BasicIntQueue] ${basicIntQueue.get()}  ${basicIntQueue.get()}")

  val doubledIntQueue = new DoubledIntQueue // OR new BasicIntQueue with Doubling
  doubledIntQueue.put(1)
  doubledIntQueue.put(2)
  println(s"[DoubledIntQueue] ${doubledIntQueue.get()}  ${doubledIntQueue.get()}")

  val fullMixIntQueueFromRightToLeft = new BasicIntQueue with Doubling with Incrementing with Filtering
  fullMixIntQueueFromRightToLeft.put(-1)
  fullMixIntQueueFromRightToLeft.put(0)
  fullMixIntQueueFromRightToLeft.put(1)
  fullMixIntQueueFromRightToLeft.put(2)
  println(s"[FullMixIntQueueFromRightToLeft] ${fullMixIntQueueFromRightToLeft.get()}  ${fullMixIntQueueFromRightToLeft.get()}")
}
