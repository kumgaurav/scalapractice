package funsets

object Excersice2{
  def main(args: Array[String]): Unit = {
    val two =  Succ(Succ(Zero))
    val one =  Succ(Zero)
    println(two+one)
    println(two-one)
    //println(one-two)
  }
}
