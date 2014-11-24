package algocity.core.procesadores;

import junit.framework.TestCase;
import algocity.core.capas.tendido.RutaPavimentada;

public class ProcesadorDeBomberosTest extends TestCase {

	ProcesadorDeBomberos proc;

	@Override
	public void setUp() {
		proc = new ProcesadorDeBomberos();
	}

	public void testTieneRutaPavimentada() {
		RutaPavimentada ruta = new RutaPavimentada();
		proc.setRutaPavimentada(ruta);
		assertEquals(ruta, proc.getRutaPavimentada());
	}

}
