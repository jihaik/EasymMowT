package fr.upem.model



object Direction {

    sealed trait EnumVal

    case object N extends EnumVal

    case object E extends EnumVal

    case object S extends EnumVal

    case object W extends EnumVal

    def withName(name:String):Direction.EnumVal=name match{
      case "North" => N
      case "East"  => E
      case "South" => S
      case "West"  => W
    }

  }



  object Commande  {

    sealed trait EnumVal

    case object G extends EnumVal

    case object D extends EnumVal

    case object A extends EnumVal

    def withName(name:String):Commande.EnumVal=name match{
      case "Gauche"  => G
      case "Droite"  => D
      case "Avancer" => A

    }

}
