package algocity.core.construibles;

import algocity.core.construibles.Industrial;
import junit.framework.TestCase;

public class IndustrialTest extends TestCase {
	
	Industrial edificio;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		edificio = new Industrial();
	}
	
	public void testCrearIndustrial(){
	}
	
	public void testConsumoIndustrial() {
		assertEquals(5, edificio.getConsumo());
	}

	public void testCostoIndustrial() {
		assertEquals(10, edificio.getCosto());
	}
	
}
