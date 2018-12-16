package com.ikempf._3

import com.ikempf._3.PartOne.{claims, input, parse, possiblePositions, usesArea}

object PartTwo extends App {

  println(findNonOverlappingClaims(claims))

  def findNonOverlappingClaims(claims: List[Claim]): Set[String] =
    claims.map(_.id).toSet -- findOverlappingClaims(claims)

  def findOverlappingClaims(claims: List[Claim]): Set[String] = {
    val overlappingClaims = Set.empty[String]

    possiblePositions(claims)
      .foldLeft(overlappingClaims) {
        case (acc, (i, j)) =>
          val claimsOnPosition = claims.filter(usesArea(i, j, _))
          if (claimsOnPosition.size >= 2)
            acc ++ claimsOnPosition.map(_.id)
          else
            acc
      }
  }

}
