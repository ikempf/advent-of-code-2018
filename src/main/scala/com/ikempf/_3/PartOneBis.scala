package com.ikempf._3

import com.ikempf._3.PartOne.parse

object PartOneBis extends App {

  val claims =
    input
      .split(System.lineSeparator)
      .map(parse)
      .toList

  println(overlaps(count(claims, emptyMatrix(claims))))

  private def overlaps(counted: List[List[Int]]): Int =
    counted.map(_.count(_ >= 2)).sum

  private def count(claims: List[Claim], emtpy: List[List[Int]]): List[List[Int]] =
    claims
      .flatMap(possiblePositions)
      .foldLeft(emtpy)((acc, pos) =>
        pos match {
          case (i, j) =>
            val inc = List(acc(i)(j) + 1)
            val lineInc = acc(i).patch(j, inc, 1)
            acc.patch(i, List(lineInc), 1)
      })

  private def possiblePositions(claim: Claim): List[(Int, Int)] =
    (for {
      i <- Range.inclusive(claim.left, claim.right)
      j <- Range.inclusive(claim.top, claim.bottom)
    } yield (i, j)).toList

  private def emptyMatrix(claims: List[Claim]): List[List[Int]] = {
    val stopLeft = claims.map(_.right).max + 1
    val stopTop  = claims.map(_.bottom).max + 1
    List.fill(stopLeft)(List.fill(stopTop)(0))
  }

  def input =
    """#1 @ 1,3: 4x4
      |#2 @ 3,1: 4x4
      |#3 @ 5,5: 2x2""".stripMargin

}
