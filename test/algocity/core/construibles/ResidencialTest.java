package algocity.core.construibles;

import junit.framework.TestCase;

public class ResidencialTest extends TestCase {


	Residencial edificio;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		edificio = new Residencial();
	}

	public void testConsumoResidencial() {
		assertEquals(edificio.getConsumo(), 1);
	}

	public void testCostoResidencial() {
		assertEquals(edificio.getCosto(), 5);
	}

	public void testAgregarUnHabitante(){
		edificio.conectarARedDeAgua();
		edificio.conectarARedElectrica();
		edificio.conectarARutaPavimentada();
		edificio.agregarHabitantes(1);
		assertEquals (99, edificio.disponibilidad());
	}

	public void testSuperarLaCantidadDeHabitantesLanzaExcepcion(){
		assertFalse(edificio.agregarHabitantes(101));
	}

	public void testAlAgregarDosPersonasYSacarUnaQuedan99Disponibles (){

		edificio.conectarARedDeAgua();
		edificio.conectarARedElectrica();
		edificio.conectarARutaPavimentada();
		try{
			edificio.agregarHabitantes(2);
			edificio.quitarHabitantes(1);
		}catch(Exception e){}
		assertEquals (99,edificio.disponibilidad());
	}

	public void TestQuitarHabitanteDeUnEdificioVacioLanzaUnaExcepcion(){
		assertFalse (edificio.quitarHabitantes(1));
	}
}