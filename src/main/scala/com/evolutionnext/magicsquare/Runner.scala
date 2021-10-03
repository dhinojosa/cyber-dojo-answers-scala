package com.evolutionnext.magicsquare

object Runner extends App {
  val nums = List(1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0)
  //val nums = (1 to 9).map(_.toDouble).toList
  private val value1 = nums.permutations
    .map(e => Square(e).map(s => s.winningElements))
    .filter(_.map(t => t._2).contains(true))
    .map(_.map(t => (t._1, t._3)))

  value1.foreach(println)
}

//1.5, 4.0, 3.5
//5.0, 3.0, 1.0
//2.5, 2.0, 4.5
