package algocity.core.construibles;

import algocity.core.construibles.Comercial;
import junit.framework.TestCase;

public class ComercialTest extends TestCase {
	
	Comercial edificio;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		edificio = new Comercial();
	}
	
	public void testCrearIndustrial(){
	}
	
	public void testConsumoIndustrial() {
		assertEquals(edificio.getConsumo(), 2);
	}

	public void testCostoIndustrial() {
		assertEquals(edificio.getCosto(), 5);
	}
}
