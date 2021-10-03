package com.evolutionnext.coinsums

import org.scalatest.{FunSuite, Matchers}

class CoinSumsTest extends FunSuite with Matchers {
  test("An empty list of options should be an error") {
    an[IllegalArgumentException] should be thrownBy CoinSums.apply(Nil, 1)
  }
  test("""Given 1 Pence out of only 1 pence""") {
    CoinSums.apply(List(1), 1) should be(List(List(1 -> 1)))
  }
  test("""Given 2 Pence out of only 1 pence""") {
    CoinSums.apply(List(1), 2) should be(List(List(1 -> 2)))
  }
  test("""Given 2 Pence out of only 1 and 2 pence""") {
    CoinSums.apply(List(1, 2), 2) should be(List(List(1 -> 2, 2 -> 0), List(1 -> 0, 2 -> 1)))
  }
  test("One pence should have only 200 pences") {
    CoinSums.apply(List(1), 200) should be(List(List(1 -> 200)))
  }
  test("""Given 5 Pence out of only 1 and 2 pence, should be
         | (1 -> 5, 2 -> 0)
         | (1 -> 3, 2 -> 1)
         | (1 -> 1, 2 -> 2)
         | """.stripMargin) {
    CoinSums.apply(List(1, 2), 5) should be(List(List(1 -> 5, 2 -> 0), List(1 -> 3, 2 -> 1), List(1 -> 1, 2 -> 2)))
  }
  test("""Given 10 Pence out of only 1,2,5 pence, should be
         | (1 -> 5, 2 -> 0, 5 -> 0)
         | (1 -> 3, 2 -> 1)
         | (1 -> 1, 2 -> 2)
         | """.stripMargin) {
    println(CoinSums.apply(List(1, 2, 5), 10))
    CoinSums.apply(List(1, 2), 5) should be(List(List(1 -> 5, 2 -> 0), List(1 -> 3, 2 -> 1), List(1 -> 1, 2 -> 2)))
  }
}
