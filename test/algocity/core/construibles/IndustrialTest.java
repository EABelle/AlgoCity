package algocity.core.construibles;

import algocity.core.construibles.Industrial;
import junit.framework.TestCase;

public class IndustrialTest extends TestCase {
	
	public void testCrearIndustrial(){
		Industrial edificio = new Industrial();
	}
	
	public void testConsumoIndustrial() {
		assertEquals(Industrial.consumo, 5);
	}

	public void testCostoIndustrial() {
		assertEquals(Industrial.costo, 10);
	}
	
}
