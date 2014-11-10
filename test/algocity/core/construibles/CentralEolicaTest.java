package algocity.core.construibles;

import algocity.core.construibles.CentralEolica;
import junit.framework.TestCase;

public class CentralEolicaTest extends TestCase {
	
	CentralEolica central;

	public void setUp() throws Exception {
		central = new CentralEolica();
	}
	
	public void testConstantesDeCentralEolica() throws Exception {
		assertEquals(central.getCosto(), 1000);
	}
	
	public void testRadioDeAlimentacion() throws Exception {
		assertEquals(central.getRadioDeAlimentacion(), 4);
	}
	
	public void testPotencia() throws Exception {
		assertEquals(central.getPotencia(), 100);
	}
	
}
