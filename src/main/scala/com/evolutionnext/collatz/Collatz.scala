package com.evolutionnext.collatz

object Collatz {
  import scala.annotation.tailrec

  def nextItem(n: BigInt): BigInt =
    if (n % 2 == 0)
      n / 2
    else
      (3 * n) + 1

  def collatzSeq(x: BigInt): List[BigInt] = {
    @tailrec
    def recurse(xs: List[BigInt]): List[BigInt] = {
      require(xs.head > 0, "Somehow we got a negative")
      if (xs.head == 1)
        xs.reverse
      else
        recurse(nextItem(xs.head) :: xs)
    }
    recurse(List(x))
  }

  val result: (Int, Int) = (1 to 999999).view.map(n => n -> collatzSeq(n).length).maxBy(_._2)
  printf("Largest Number: %d, Collatz Size: %d", result._1, result._2)
}
