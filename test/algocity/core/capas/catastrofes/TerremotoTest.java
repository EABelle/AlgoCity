package algocity.core.capas.catastrofes;

import junit.framework.TestCase;
import algocity.core.Mapa;
import algocity.core.Partida;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.EstacionDeBombero;
import algocity.core.construibles.Residencial;

public class TerremotoTest extends TestCase{

	public void test01TerremotoDaniaUn50PorCientoEnEpicentro(){

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		partida.setConCatastrofes(false);
		Residencial residencial = new Residencial();

		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(residencial, 0, 10);

		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(0, j);
		}

		Terremoto terremoto = new Terremoto(0, 10);
		terremoto.procesar(mapa);

		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertFalse (residencial.daniado());
	}

	public void test02TerremotoDaniaUn20PorCientoAlPropagarse30Hectareas(){

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		partida.setConCatastrofes(false);
		Residencial residencial = new Residencial();

		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(residencial, 0, 10);

		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(0, j);
		}

		Terremoto terremoto = new Terremoto(0, 27);

		terremoto.procesar(mapa);

		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertFalse (residencial.daniado());
	}
}
