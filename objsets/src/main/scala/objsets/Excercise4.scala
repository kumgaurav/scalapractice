package objsets

trait Expr:
  def isNumber: Boolean
  def isSum : Boolean
  def numValue: Int
  def leftOp : Expr
  def rightOp: Expr


class Number(n: Int) extends Expr :
  def isNumber:Boolean = true
  def isSum: Boolean = false
  def numValue:Int = n
  def leftOp : Expr = throw Error("Number.leftOp")
  def rightOp : Expr = throw Error("Number.rightOp")

class sum(e1: Expr, e2: Expr) extends Expr :
  override def isNumber: Boolean = false
  override def isSum: Boolean = true
  override def numValue: Int = throw Error("Sum.numValue")
  override def leftOp: Expr = e1
  override def rightOp: Expr = e2

  def eval(e:Expr):Int = {
    if(e.isNumber) then e.numValue
    else if (e.isSum) then eval(e.leftOp) + eval(e.rightOp)
    else throw Error("Unknown Exception : "+e)
  }


class Excercise4 {

}
