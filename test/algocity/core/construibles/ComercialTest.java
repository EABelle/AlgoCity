package algocity.core.construibles;

import algocity.core.construibles.Comercial;
import junit.framework.TestCase;

public class ComercialTest extends TestCase {
	
	public void testCrearComercial(){
		Comercial edificio = new Comercial();
	}
	
	public void testCostoComercial() {
		assertEquals(5, Comercial.costo);
	}
	
	public void testConsumoComercial() {
		assertEquals(2, Comercial.consumo);
	}
}
