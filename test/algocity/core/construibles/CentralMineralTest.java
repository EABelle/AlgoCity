package algocity.core.construibles;

import algocity.core.construibles.CentralMineral;
import junit.framework.TestCase;

public class CentralMineralTest extends TestCase {
	
	CentralMineral central;

	public void setUp() throws Exception {
		central = new CentralMineral();
	}
	
	public void testConstantesDeCentralEolica() throws Exception {
		assertEquals(central.getCosto(), 3000);
	}
	
	public void testRadioDeAlimentacion() throws Exception {
		assertEquals(central.getRadioDeAlimentacion(), 10);
	}
	
	public void testPotencia() throws Exception {
		assertEquals(central.getPotencia(), 400);
	}
}
