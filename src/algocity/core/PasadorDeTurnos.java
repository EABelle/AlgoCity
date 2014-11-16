package algocity.core;

import java.util.ArrayList;

import algocity.core.Partida.NodoEdificioDaniado;
import algocity.core.capas.tendido.RutaPavimentada;

public class PasadorDeTurnos {

	public void pasarTurno(Partida partida, Mapa mapa, RutaPavimentada ruta,
			ArrayList<NodoEdificioDaniado> edificiosDaniados) {
		mapa.procesarTurno(partida);
		ruta.mandarBomberos(partida, edificiosDaniados);
		partida.pasoTurno();
		
	}
}
