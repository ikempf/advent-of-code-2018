package com.ikempf._1

object PartTwo extends App {

  val frequencyChanges =
    input
      .split(System.lineSeparator)
      .toList
      .map(_.toInt)

  val loopingFrequencies =
    Stream
      .iterate(frequencyChanges)(_ => frequencyChanges)
      .flatMap(a => Stream(a: _*))
      .scan(0)(_ + _)
      .tail

  def firstDuplicate[A](l: Stream[A]): A = {
    def firstDuplicateRec(visited: Set[A], l: Stream[A]): A =
      if (visited.contains(l.head))
        l.head
      else
        firstDuplicateRec(visited + l.head, l.tail)

    firstDuplicateRec(Set.empty[A], l)
  }

  println(firstDuplicate(loopingFrequencies))

  def input =
    """-19
      |+8
      |-10 """.stripMargin

}
