package fiuba.algo3;

import junit.framework.TestCase;

public class ResidencialTest extends TestCase {
	
	public void testCrearResidencial(){
		Residencial edificio = new Residencial();
	}
	
	public void testAgregarUnHabitante(){
		Residencial edificio = new Residencial();
		edificio.agregarHabitantes(1);
		assertTrue( 99 , edificio.disponibilidad());
	}

}
