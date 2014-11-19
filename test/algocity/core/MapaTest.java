package algocity.core;

import algocity.core.capas.HectareaLlana;
import junit.framework.TestCase;

public class MapaTest extends TestCase {

		public void testCrearUnMapaDe10x10PermiteCargar100Hectareas() {
			int i = 0;
			Mapa mapa = new Mapa(10,10);
			while (!mapa.cargarHectareaNueva(new HectareaLlana())) {
				i ++;
			}
			assertEquals (100, i);
		}
		
		public void testMapaSeLlena() {
			Mapa mapa = new Mapa(10, 10);
			mapa.llenar();
			assertTrue(mapa.cargado());
		}
}
