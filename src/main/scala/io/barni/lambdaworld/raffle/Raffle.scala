package io.barni.lambdaworld.raffle

import java.math.BigInteger
import java.security.SecureRandom

import scala.io.Source
import scala.util.Random
object Raffle extends App {

  private val random = new SecureRandom()
  val filename = "path-to-file-name"
  val indexSeed = new BigInteger(20, random).doubleValue().toInt

  val participantsb = Source.fromFile(filename).getLines.toList

  val participants = Random.shuffle(participantsb)
  val nrOfDuplicates = participants.groupBy(identity).count{case (_,cica) => cica.size > 1}
  val nrOfParticipants = participants.size
  participants(indexSeed % nrOfParticipants)
}
