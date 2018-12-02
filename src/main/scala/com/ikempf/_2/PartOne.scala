package com.ikempf._2

object PartOne extends App {

  val boxIds = input.split(System.lineSeparator).toList
  println(checksum(boxIds))

  def checksum(boxIds: List[String]): Int = {
    val (twos, threes) = pairings(boxIds)
    twos * threes
  }

  def pairings(boxIds: List[String]): (Int, Int) = {
    val tuples = boxIds.map(pairings)
    val has2 = tuples.count(_._1)
    val has3 = tuples.count(_._2)

    (has2, has3)
  }

  def pairings(boxId: String): (Boolean, Boolean) = {
    val chars = boxId.toCharArray.toList

    def hasPairing(n: Int) = chars.exists(c => chars.count(_ == c) == n)

    (hasPairing(2), hasPairing(3))
  }

  def input =
    """abcdef
      |bababc
      |abbcde
      |abcccd
      |aabcdd
      |abcdee
      |ababab""".stripMargin

}
