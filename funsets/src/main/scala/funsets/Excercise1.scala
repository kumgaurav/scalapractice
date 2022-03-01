package funsets



/**
 * Write a function nth that takes a list and an ineteger and selects the nth element of the list.
 */
object Excersice1 {
  def main(args: Array[String]): Unit = {
    //val l1 = CONS(3, NIL())
    //passing 2 will return 3 and 3 will return indexoutofboundexception
    println(nth(CONS(1, CONS(2, CONS(3, NIL()))), 3))
  }

  def nth[T](xs: LIST[T], n: Int): T = {
    if(xs.isEmpty) then throw IndexOutOfBoundsException()
    else if (n == 0 ) then xs.head
    else nth(xs.tail, n-1)
  }

}
