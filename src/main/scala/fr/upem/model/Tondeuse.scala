package fr.upem.model



  case class Tondeuse (propos: Propos,direction:Direction.EnumVal) {
    def print: String = this.propos.a + "" + this.propos.b + "" + this.direction.toString





}
