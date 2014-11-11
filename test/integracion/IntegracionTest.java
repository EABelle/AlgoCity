package integracion;

import algocity.core.Mapa;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.CentralEolica;
import junit.framework.TestCase;

public class IntegracionTest extends TestCase {
	
	public void testagregarUnaCentralEolicaAlimenta4Hectareas() {
		Mapa mapa = new Mapa(10,10);
		while (mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		CentralEolica central = new CentralEolica();
		mapa.agregarConstruible(central, 4, 4);
		assertTrue ((mapa.getHectarea(1, 2).redElectricaConectada()));
	}
}
