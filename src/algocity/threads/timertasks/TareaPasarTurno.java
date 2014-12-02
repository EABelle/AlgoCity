package algocity.threads.timertasks;

import java.util.TimerTask;

import algocity.controladores.PasadorDeTurno;

public class TareaPasarTurno extends TimerTask {

	private PasadorDeTurno pasadorDeTurno;

	public TareaPasarTurno(PasadorDeTurno pasadorDeTurno) {
		this.pasadorDeTurno = pasadorDeTurno;
	}

	@Override
	public void run() {
		pasadorDeTurno.pasarTurno();
	}

}
