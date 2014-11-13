package algocity.core.capas;

import junit.framework.TestCase;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.CentralNuclear;
import algocity.core.construibles.Comercial;
import algocity.core.construibles.Industrial;
import algocity.core.construibles.PozoDeAgua;
import algocity.core.construibles.Residencial;

public class HectareaLlanaTest extends TestCase {
	
	public void testCrearHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
	}
	
	public void testSeAgregaResidecialEnHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
		assertTrue (llanura.agregarConstruible(new Residencial()));
	}
	
	public void testSeAgregaComercialEnHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
		assertTrue (llanura.agregarConstruible (new Comercial()));
	}
	
	public void testAgregarUnPozoDeAguaEnHectareaLlanaLanzaExcepcion(){
		HectareaLlana llanura = new HectareaLlana();
		assertFalse (llanura.agregarConstruible(new PozoDeAgua()));
	}
	
	public void testNoSePuedeAgregarDosEdificiosEnLaMismaHectarea() {
		HectareaLlana llanura = new HectareaLlana();
		assertTrue (llanura.agregarConstruible(new CentralNuclear()));
		assertFalse (llanura.agregarConstruible(new Industrial()));
	}
	
	public void testNoSePuedeBorrarUnEdificioSiNoLoHay() {
		HectareaLlana llanura = new HectareaLlana();
		assertFalse (llanura.borrarConstruible());
		
	}
	
	public void testSePuedeBorrarUnEdificio() {
		HectareaLlana llanura = new HectareaLlana();
		assertTrue (llanura.agregarConstruible(new CentralNuclear()));
		assertTrue (llanura.borrarConstruible());	
	}
	
	public void testSePuedeAgregarNuevoEdificoLuegoDeBorrarElAnterior() {
		HectareaLlana llanura = new HectareaLlana();
		assertTrue (llanura.agregarConstruible(new CentralNuclear()));
		llanura.borrarConstruible();
		assertTrue (llanura.agregarConstruible(new Industrial()));	
	}

}
