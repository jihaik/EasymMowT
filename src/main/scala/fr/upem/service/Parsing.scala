package fr.upem.service

import java.io.File

import fr.upem.model.{Pelouse, Propos}
import fr.upem.model.Tondeuse
import fr.upem.model.Direction
import fr.upem.model.Commande
import scala.io.Source

class Parsing {

  class ParsingService {
    def getPelous(file: File): Option[Pelouse] = {
      val input = Source.fromFile(file).getLines().toList
      if(!input.isEmpty) {
        val coordinateArray = input(0).split(" ")
        if(coordinateArray.length != 2) None else Some(
          Pelouse(Propos(coordinateArray(0).toInt, coordinateArray(1).toInt)))
      } else None
    }


    def getTondeuses(file: File): List[Tondeuse] = {
      val input = Source.fromFile(file).getLines().toList
      if(!input.isEmpty && input.length > 1) {
        val tondeuseLines = input.zipWithIndex.filter{
          case (item, index) => index != 0 && index % 2 != 0
        }.map(_._1)
        tondeuseLines.filter(_.split(" ").length == 3).map(line => {
          val tondeuseParams = line.split(" ")
          Tondeuse(Propos(tondeuseParams(0).toInt, tondeuseParams(1).toInt), Direction.withName(tondeuseParams(2)))
        })
      } else List.empty[Tondeuse]

    }

    def getCommandes(file: File): List[List[Commande.EnumVal]] = {
      val input = Source.fromFile(file).getLines().toList
      if(!input.isEmpty && input.length > 2) {
        val commandLines = input.zipWithIndex.filter{
          case (item, index) => index != 0 && index % 2 == 0
        }.map(_._1)
        commandLines.map(line  => line.toList.map(cmd => Commande.withName(cmd.toString)))
      } else List.empty[List[Commande.EnumVal]]
    }

  }

}
