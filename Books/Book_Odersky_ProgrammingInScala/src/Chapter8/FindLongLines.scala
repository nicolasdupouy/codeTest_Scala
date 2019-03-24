package Chapter8

object FindLongLines extends App {
  val width = args(0).toInt
  for(arg <- args.drop(1))
    LongLines.processFile(arg, width)
}
