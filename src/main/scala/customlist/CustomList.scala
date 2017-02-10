package customlist

/**
  * Created by kirankumarbs on 10/7/2016.
  */
trait CustomList[+T] {
  def head: T
  def tail: CustomList[T]
}

case object Nil extends CustomList[Nothing] {
  override def head: Nothing = throw new Error("Empty List Can't has Head")
  override def tail: Nothing = throw new Error("Empty List Can't has Tail")
}

case class Cons[T](head:T, tail: CustomList[T]) extends CustomList[T] {
  override def toString = {
    def loop(list:CustomList[T],acc:String): String = list match {
      case Nil => acc
      case x:CustomList[T] => loop(x.tail,acc + ","+x.head)
    }
    "["+loop(tail,head.toString)+"]"
  }
}

object CustomListRun{
  def main(args: Array[String]) {
    println(Cons(1,Cons(2,Cons(5,Cons(7,Nil)))))
    println(Cons(1.8,Cons(2.6,Cons(5.3,Cons(7.9,Nil)))))
    println(Cons('s',Cons('T',Cons('B',Cons('F',Nil)))))
    println(Cons("Banana",Cons("Orange",Cons("aPPle",Cons("Pappaya",Nil)))))
    println(Nil)
    //println(Cons(null,Nil))

  }
}
