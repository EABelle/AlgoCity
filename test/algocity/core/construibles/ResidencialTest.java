package algocity.core.construibles;

import algocity.core.EspacioInsuficienteException;
import algocity.core.NoHayTantosHabitantesException;
import algocity.core.construibles.Residencial;
import junit.framework.TestCase;

public class ResidencialTest extends TestCase {
	
	public void testCrearResidencial(){
		Residencial edificio = new Residencial();
	}
	
	public void testAgregarUnHabitante(){
		Residencial edificio = new Residencial();
		try{
			edificio.agregarHabitantes(1);
		}catch (EspacioInsuficienteException e){}
		assertEquals (99, edificio.disponibilidad());
	}
	
	public void testSuperarLaCantidadDeHabitantesLanzaExcepcion(){
		Residencial edificio = new Residencial();
		boolean excepcionLanzada = false;
		try{
			edificio.agregarHabitantes(101);
		}catch (EspacioInsuficienteException e){
			excepcionLanzada = true;
		}
		assertTrue (excepcionLanzada);
	}
	
	public void testAlAgregarDosPersonasYSacarUnaQuedan99Disponibles (){
		Residencial edificio = new Residencial();
		try{
			edificio.agregarHabitantes(2);
			edificio.quitarHabitantes(1);
		}catch(Exception e){}
		assertEquals (99,edificio.disponibilidad());
	}
	
	public void TestQuitarHabitanteDeUnEdificioVacioLanzaUnaExcepcion(){
		Residencial edificio = new Residencial();
		boolean excepcionLanzada = false;
		try{
			edificio.quitarHabitantes(1);
		}catch(NoHayTantosHabitantesException e){
			excepcionLanzada = true;
		}
		assertTrue (excepcionLanzada);
	}
}