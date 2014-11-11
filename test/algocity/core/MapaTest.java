package algocity.core;

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
}
