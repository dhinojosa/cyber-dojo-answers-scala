package com.evolutionnext.pandigitalproducts

object PanDigitalProducts extends App {
  def splitByDouble(s: String, triple: (Int, Int)): (Int, Int, Int) =
    (s.substring(0, triple._1).toInt, s.substring(triple._1, triple._2).toInt, s.substring(triple._2).toInt)

  def splitDigits(seq: Seq[Int]) =
    (1 to 8).combinations(2).map(p => splitByDouble(seq.mkString, p(0) -> p(1)))

  def isProduct(triplet: (Int, Int, Int)): Boolean =
    triplet._1 * triplet._2 == triplet._3

  private val panDigitals =
    (1 to 9)
      .permutations
      .flatMap(splitDigits)
      .filter(isProduct)
      .to(LazyList)

  panDigitals.foreach(println)
  println(panDigitals.size)
}
