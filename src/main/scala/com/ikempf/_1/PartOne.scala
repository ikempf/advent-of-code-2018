package com.ikempf._1

object PartOne extends App {

  val finalFrequency: Int =
    input
      .split(System.lineSeparator)
      .toList
      .map(_.toInt)
      .sum

  println(finalFrequency)

  def input =
    """-19
      |+8
      |-10""".stripMargin

}
