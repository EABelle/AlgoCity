package algocity.core.construibles;

import algocity.core.construibles.CentralNuclear;
import junit.framework.TestCase;

public class CentralNuclearTest extends TestCase {
	
	CentralNuclear central;

	public void setUp() throws Exception {
		central = new CentralNuclear();
	}
	
	public void testConstantesDeCentralEolica() throws Exception {
		assertEquals(central.getCosto(), 10000);
	}
	
	public void testRadioDeAlimentacion() throws Exception {
		assertEquals(central.getRadioDeAlimentacion(), 25);
	}
	
	public void testPotencia() throws Exception {
		assertEquals(central.getPotencia(), 1000);
	}
}
