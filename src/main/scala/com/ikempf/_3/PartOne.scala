package com.ikempf._3

case class Claim(number: String, left: Int, top: Int, width: Int, height: Int) {
  val right: Int  = left + width - 1
  val bottom: Int = top + height - 1
}

object PartOne extends App {

  val claims =
    input
      .split(System.lineSeparator)
      .map(parse)
      .toList

  println(overlap(claims))

  def parse(claim: String): Claim = {
    val Array(number, spec)  = claim.split('@')
    val Array(dist, size)    = spec.split(':')
    val Array(left, top)     = dist.split(',').map(_.trim.toInt)
    val Array(width, height) = size.split('x').map(_.trim.toInt)

    Claim(number, left, top, width, height)
  }

  def overlap(claims: List[Claim]): Int =
    possiblePositions(claims)
      .count {
        case (i, j) =>
          claims.count(usesArea(i, j, _)) >= 2
      }

  private def possiblePositions(claims: List[Claim]) = {
    val startLeft = claims.map(_.left).min
    val startTop  = claims.map(_.top).min
    val stopLeft  = claims.map(_.right).max + 1
    val stopTop   = claims.map(_.bottom).max + 1

    for {
      i <- Range.apply(startLeft, stopLeft)
      j <- Range(startTop, stopTop)
    } yield (i, j)
  }

  def usesArea(i: Int, j: Int, claim: Claim): Boolean = {
    val horizontalInside = claim.left <= i && i <= claim.right
    val verticalInside   = claim.top <= j && j <= claim.bottom

    horizontalInside && verticalInside
  }

  def input =
    """#1 @ 1,3: 4x4
      |#2 @ 3,1: 4x4
      |#3 @ 5,5: 2x2""".stripMargin

}
