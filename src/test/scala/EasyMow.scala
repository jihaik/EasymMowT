import fr.upem.model.{Direction, _}
import fr.upem.service.TondeuseService

import org.junit.Assert._
import org.junit.Test


class EasyMow {



		@Test
		def testCase() = {
		val tondesueService = new TondeuseService
		val pelouse = Pelouse(Propos(5, 5))

		val tendeuse1 = Tondeuse(Propos(1, 2), Direction.N)
		val commands1: Seq[Commande.EnumVal] = Seq(Commande.G, Commande.A, Commande.G, Commande.A, Commande.G, Commande.A, Commande.G, Commande.A, Commande.A)
		val movedTondeuse1 = commands1.foldLeft(tendeuse1)((accumulator, command)  => tondesueService.moveTondeuse(accumulator, pelouse, command))
		assertEquals(1, movedTondeuse1.propos.a)
		assertEquals(3, movedTondeuse1.propos.b)
		assertEquals(Direction.N , movedTondeuse1.direction)

		val tendeuse2 = Tondeuse(Propos(3, 3), Direction.E)
		val commands2: Seq[Commande.EnumVal] = Seq(Commande.A, Commande.A, Commande.D, Commande.A, Commande.A, Commande.D, Commande.A, Commande.D, Commande.D, Commande.A)
		val movedTondeuse2 = commands2.foldLeft(tendeuse2)((accumulator, command)  => tondesueService.moveTondeuse(accumulator, pelouse, command))
		assertEquals(5, movedTondeuse2.propos.a)
		assertEquals(1, movedTondeuse2.propos.b)
		assertEquals(Direction.E, movedTondeuse2.direction)
	}
}
