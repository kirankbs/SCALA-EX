package dataorcode

/**
  * Created by kirankumar on 24-09-2016.
  */

trait Nat{
  def isZero:Boolean
  def successor: Nat = new Succ(this)
  def predecessor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
  def length: Int
}

object Zero extends Nat{
  def isZero: Boolean = true
  def predecessor: Nat = throw new Error("0.predecessor")
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = if(that.isZero) this else throw new Error("0.Substraction")
  def length: Int = 0
}

class Succ(n: Nat) extends Nat{
  def isZero: Boolean = false
  def predecessor: Nat = n
  def +(that: Nat): Nat = new Succ(n + that)
  def -(that: Nat): Nat = if(that.isZero ) this else n - that.predecessor
  def length: Int = n match {
    case Zero => 1
    case _ => 1 + n.length
  }
}