package example

object ExampleCurryFunctions {
  def main(args: Array[String]): Unit = {
    println(product(x=> x*x)(1,5))
    //println(fact(5))
    //println(sum(fact)(1,5))
    println(product2(identity)(1, 5))
  }

  def product(f: Int => Int)(a:Int , b:Int): Int =
    if a > b then 1 else f(a) * product(f)(a+1,b)


  def fact(n: Int) = product(x => x)(1, n)

  def mapReduce(f:Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:Int) : Int =
    def recur(a:Int):Int =
      if(a>b) then zero
      else combine(f(a), recur(a+1))
    recur(a)

  def sum(f:Int => Int) = mapReduce(f, (x,y) => x+y, 0)
  def product2(f: Int => Int) = mapReduce(f, (x,y) => x*y , 1)

}
