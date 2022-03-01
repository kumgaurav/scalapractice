package example

object Fibonacci :
 def fibonacci(n : Int ): Int = {
   if(n<=1) return 1 else n* fibonacci(n-1)
 }