package algocity.core.construibles;

import algocity.core.construibles.Residencial;
import algocity.core.exceptions.EspacioInsuficienteException;
import algocity.core.exceptions.NoHayTantosHabitantesException;
import junit.framework.TestCase;

public class ResidencialTest extends TestCase {
	
	
	Residencial edificio;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
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
		try{
			edificio.agregarHabitantes(1);
		}catch (EspacioInsuficienteException e){}
		assertEquals (99, edificio.disponibilidad());
	}
	
	public void testSuperarLaCantidadDeHabitantesLanzaExcepcion(){
		boolean excepcionLanzada = false;
		try{
			edificio.agregarHabitantes(101);
		}catch (EspacioInsuficienteException e){
			excepcionLanzada = true;
		}
		assertTrue (excepcionLanzada);
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
		boolean excepcionLanzada = false;
		try{
			edificio.quitarHabitantes(1);
		}catch(NoHayTantosHabitantesException e){
			excepcionLanzada = true;
		}
		assertTrue (excepcionLanzada);
	}
}