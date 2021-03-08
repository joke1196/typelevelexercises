package com.shogun

object TLPExercise {

  import scala.reflect.runtime.universe._

  private def show[T](value: T)(implicit tag: TypeTag[T]) = tag.toString.replace("com.shogun.TLPExercise.", "")

  trait Nat

  class _0 extends Nat

  class Succ[N <: Nat] extends Nat

  type _1 = Succ[_0]
  type _2 = Succ[_1] // = Succ[Succ[_0]]
  type _3 = Succ[_2] // = Succ[Succ[Succ[_0]]]
  type _4 = Succ[_3] // ... and so on
  type _5 = Succ[_4]


  sealed trait <[A <: Nat, B <: Nat]

  object < {
    implicit def basicLT[B <: Nat] = ???

    implicit def inductive[A <: Nat, B <: Nat](implicit lt: <[A, B]) = ???

    def apply[A <: Nat, B <: Nat](implicit lt: <[A, B]): A < B = lt
  }

//  val isLower: _2 < _3 = <[_2, _3]

  //  val notLower = <[_3, _1]


  sealed trait +[A <: Nat, B <: Nat] extends Nat {
    type Result <: Nat
  }
  object + {
    type PlusOp[A <: Nat, B <: Nat, S <: Nat] = +[A, B] {type Result = S}
    ???
  }


  def main(args: Array[String]): Unit = {
//    println(show(+[_2, _3]))
  }

}
