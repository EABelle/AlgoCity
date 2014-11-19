package algocity.core;

import junit.framework.TestCase;

public class PartidaTest extends TestCase {
	
	public void testPartidaSeCrea() {
		Partida partida = new Partida(new Mapa(10, 14));
		assertFalse(partida.inicializada());
	}
	
	public void testPartidaSeInicializa() {
		Partida partida = new Partida(new Mapa(10, 10));
		partida.inicializar();
		assertTrue(partida.inicializada());
	}

}
