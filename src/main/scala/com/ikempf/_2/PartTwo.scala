package com.ikempf._2

object PartTwo extends App {

  val boxIds = input.split(System.lineSeparator).toList
  println(findCommonChars(boxIds))

  def findCommonChars(boxIds: List[String]): String = {
    val (fst, snd) = findCorrectBoxIds(boxIds)
    findCommonChars(fst, snd)
  }

  def findCommonChars(boxId1: String, boxId2: String): String =
    boxId1.filter(boxId2.contains(_))

  def findCorrectBoxIds(boxIds: List[String]): (String, String) = {
    val boxId1 = boxIds.toStream.filter(boxId => boxIds.exists(almostEq(_, boxId))).head
    val boxId2 = boxIds.find(almostEq(_, boxId1)).get
    (boxId1, boxId2)
  }

  def almostEq(boxId1: String, boxId2: String): Boolean =
    boxId1.zip(boxId2).count { case (fst, snd) => fst != snd } == 1

  def input =
    """abcde
      |fghij
      |klmno
      |pqrst
      |fguij
      |axcye
      |wvxyz""".stripMargin

}
