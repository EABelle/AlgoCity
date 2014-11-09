package algocity.core.construibles;

import algocity.core.EspacioInsuficiente;
import algocity.core.NoHayTantosHabitantes;
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
		}catch (EspacioInsuficiente e){}
		assertEquals (99, edificio.disponibilidad());
	}
	
	public void testSuperarLaCantidadDeHabitantesLanzaExcepcion(){
		Residencial edificio = new Residencial();
		boolean excepcionLanzada = false;
		try{
			edificio.agregarHabitantes(101);
		}catch (EspacioInsuficiente e){
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
		}catch(NoHayTantosHabitantes e){
			excepcionLanzada = true;
		}
		assertTrue (excepcionLanzada);
	}
}