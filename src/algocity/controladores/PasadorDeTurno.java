package algocity.controladores;

import algocity.core.Partida;
import algocity.threads.ProcesoTimerTurno;

public class PasadorDeTurno {

	private Partida partida;

	public PasadorDeTurno(Partida partida) {
		this.partida = partida;
	}

	public void pasarTurno() {
		this.partida.pasarTurno();
		
	}

}
