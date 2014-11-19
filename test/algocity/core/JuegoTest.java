package algocity.core;
import junit.framework.TestCase;


public class JuegoTest extends TestCase {
	
	public void testJuegoSeInicializa() {
		Juego juego = new Juego();
	}

	public void testSeCreaUnMapa() {
		Juego juego = new Juego();
		juego.prepararMapa(10, 15);
		Mapa mapa = juego.getMapa();
		assertEquals(10, mapa.getFilas());
		assertEquals(15, mapa.getColumnas());
	}
}
