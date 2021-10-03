package com.evolutionnext.magicsquare

import org.scalatest.{FunSuite, Matchers}

class SquareTest extends FunSuite with Matchers {

  test("A Square of 1 should just be itself") {
    val result = Square(List(1.0))
    result should be(Right(Square(List(List(1.0)))))
  }

  test("A Square of 4 should just be on one row 1,2 and then 3,4 in another") {
    val result = Square(List(1, 2, 3.0, 4))
    result should be(Right(Square(List(List(1, 2.0), List(3, 4.0)))))
  }

  test(
    "A Square of 9 should just be on one row 1,2,3 and then 4,5,6 and then 7,8,9 in another"
  ) {
    val result = Square(List(1, 2.0, 3, 4, 5, 6, 7, 8, 9))
    result should be(
      Right(Square(List(List(1, 2, 3.0), List(4, 5, 6.0), List(7.0, 8, 9))))
    )
  }

  test("A Square of 10 elements should just error, since it is not a square") {
    val result = Square(List(1.0, 2, 3, 4, 5, 6, 7, 8.0, 9, 10))
    result should be(Left("Number of Elements are not a square"))
  }

  test("""A Square of no elements should not be allowed since 0 seems
          |  it would do something wrong""".stripMargin) {
    val result = Square(List.empty[Double])
    result should be(Left("An empty list is not allowed"))
  }

  test("if it is a square") {
    Square.isSquare(16) should be(true)
  }

  test("if it is a not a square") {
    Square.isSquare(17) should be(false)
  }

  test("Calculate row sums with 1x1") {
    val sq = Square(List(1.0))
    sq.map(sq => sq.rowSums should be(List(1)))
  }

  test("Calculate row sums with 2x2") {
    val sq = Square(List(1, 2, 3, 4.0))
    sq.map(sq => sq.rowSums should be(List(3, 7)))
  }

  test("Calculate row sums with 3x3") {
    val sq = Square(List(1, 2, 3, 4, 5.0, 6, 7, 8, 9))
    sq.map(sq => sq.rowSums should be(List(6.0, 15, 24)))
  }

  test("Calculate column sums with 1x1") {
    val sq = Square(List(1.0))
    sq.map(sq => sq.columnSums should be(List(1.0)))
  }

  test("Calculate column sums with 2x2") {
    val sq = Square(List(1.0, 2.0, 3.0, 4.0))
    sq.map(sq => sq.columnSums should be(List(4.0, 6.0)))
  }

  test("Calculate column sums with 3x3") {
    val sq = Square(List(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0))
    sq.map(sq => sq.columnSums should be(List(12.0, 15.0, 18.0)))
  }

  test("Calculate backslash style diagonal with 1x1") {
    val sq = Square(List(1.0))
    sq.map(sq => sq.backSlashDiagonalSum should be(1.0))
  }

  //1 2
  //3 4

  test("Calculate backslash style diagonal with 2x2") {
    val sq = Square(List(1.0, 2.0, 3.0, 4.0))
    sq.map(sq => sq.backSlashDiagonalSum should be(5.0))
  }

  test("Calculate backslash style diagonal with 3x3") {
    //1 2 3
    //4 5 6
    //7 8 9
    val sq = Square(List(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0))
    sq.map(sq => sq.backSlashDiagonalSum should be(15.0))
  }

  test("Calculate forwardSlash style diagonal with 1x1") {
    val sq = Square(List(1.0))
    sq.map(sq => sq.forwardSlashDiagonalSum should be(1.0))
  }

  test("Calculate forwardSlash style diagonal with 2x2") {
    //1 2
    //3 4
    val sq = Square(List(1.0, 2.0, 3.0, 4.0))
    sq.map(sq => sq.forwardSlashDiagonalSum should be(5.0))
  }

  test("Calculate forwardSlash style diagonal with 3x3") {
    //1 2 4
    //4 5 6
    //7 8 9
    val sq = Square(List(1.0, 2.0, 4.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0))
    sq.map(sq => sq.forwardSlashDiagonalSum should be(16.0))
  }
}
