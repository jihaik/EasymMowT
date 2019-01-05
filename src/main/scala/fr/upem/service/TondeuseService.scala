package fr.upem.service

import fr.upem.model._
class TondeuseService {




  def moveTondeuse(inputTondeuse: Tondeuse, pelouse: Pelouse, commande: Commande.EnumVal): Tondeuse = {
    commande match {
      case Commande.G => inputTondeuse.copy(direction = leftRight(inputTondeuse.direction)._1)
      case Commande.D => inputTondeuse.copy(direction = leftRight(inputTondeuse.direction)._2)
      case Commande.A=> {
        val newCoordinates = computeCoordinates(inputTondeuse.propos, inputTondeuse.direction)

        if(newCoordinates.a >= 0 && newCoordinates.b>= 0 && newCoordinates.a <= pelouse.hautDroit.a && newCoordinates.b <= pelouse.hautDroit.b)
          inputTondeuse.copy(propos = newCoordinates) else inputTondeuse
      }
      case _ => inputTondeuse
    }
  }
  private def leftRight(currentDirection: Direction.EnumVal): (Direction.EnumVal, Direction.EnumVal) = currentDirection match {
    case Direction.N=> (Direction.W, Direction.E)
    case Direction.E => (Direction.N, Direction.S)
    case Direction.S=> (Direction.E, Direction.W)
    case Direction.W=> (Direction.S, Direction.N)
    case _ => (currentDirection, currentDirection)
  }
  private def computeCoordinates(currentCoordinates: Propos, currentDirection: Direction.EnumVal): Propos = currentDirection match {
    case Direction.N => currentCoordinates.copy(b = currentCoordinates.b + 1)
    case Direction.E=> currentCoordinates.copy(a = currentCoordinates.a + 1)
    case Direction.S=> currentCoordinates.copy(b = currentCoordinates.b - 1)
    case Direction.W => currentCoordinates.copy(a = currentCoordinates.a - 1)
    case _ => currentCoordinates
  }

}


