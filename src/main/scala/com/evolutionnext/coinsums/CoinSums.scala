package com.evolutionnext.coinsums

object CoinSums extends App {

  def helper(coins: List[Int], limit: Int, acc: List[(Int, Int)]): List[List[(Int, Int)]] = {
    if (coins.length == 1) List(coins.head -> (limit / coins.head) :: acc)
    else {
      val last = coins.last
      (0 to limit / last)
        .map(i => last -> i)
        .flatMap(t => helper(coins.init, limit - (t._1 * t._2), t :: acc))
        .toList
    }
  }

  def apply(coins: List[Int], limit: Int): List[List[(Int, Int)]] = {
    require(coins.nonEmpty, "List must have denomination of coins")
    helper(coins, limit, Nil)
  }

  println(apply(List(1, 2, 5, 10, 20, 50, 100, 200), 200).mkString("\n"))
  println(apply(List(1, 2, 5, 10, 20, 50, 100, 200), 200).size)
}
