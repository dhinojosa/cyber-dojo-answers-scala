package com.evolutionnext.magicsquare

case class Square private (list: List[List[Double]]) {
  def rowSums: List[Double] = list.map(xs => xs.sum)
  def columnSums: List[Double] =
    list.reduce((xs, ys) => for { (a, b) <- xs zip ys } yield a + b)

  def winningElements: (List[List[Double]], Boolean, List[Double]) = {
    val e = rowSums ++ columnSums :+ backSlashDiagonalSum :+ forwardSlashDiagonalSum
    (list, e.forall(x => x == e.head), e)
  }

  def backSlashDiagonalSum: Double =
    (list.indices zip list).map { case (i, xs) => xs(i) }.sum

  def forwardSlashDiagonalSum: Double =
    ((list.length - 1 to 0 by -1) zip list).map { case (i, xs) => xs(i) }.sum

//  def backSlashDiagonalSums: List[Double] = {
//    val range = list.length - 1 to 0 by -1
//    val counts = range zip range.reverse
//    processWithCounts(counts)
//  }

//  private def processWithCounts(counts: IndexedSeq[(Int, Int)]) = {
//    val restructure: List[List[Double]] =
//      (counts zip list).toList
//        .map {
//          case ((x, y), xs) =>
//            List.fill(x)(0.0) ++ xs ++ List.fill(y)(0.0)
//        }
//    calcColumnSums(restructure)
//  }

//  def forwardSlashDiagonalSums: List[Double] = {
//    val range = list.length - 1 to 0 by -1
//    val counts = range.reverse zip range
//    processWithCounts(counts)
//  }
}

object Square {
  import scala.math._

  def isSquare(i: Double): Boolean = sqrt(i) - floor(sqrt(i)) == 0.0

  def apply(value: List[Double]): Either[String, Square] =
    if (value.isEmpty) Left("An empty list is not allowed")
    else if (!isSquare(value.size)) Left("Number of Elements are not a square")
    else Right(Square(value.grouped(sqrt(value.size).toInt).toList))
}
