package algocity.threads.timertasks;

import java.util.Timer;
import java.util.TimerTask;

import algocity.core.Partida;
import algocity.threads.ProcesoTimerTurno;

public class TareaContarSegundos extends TimerTask {

	private int estadoCuentaRegresiva;
	private ProcesoTimerTurno timerJuego;
	private Partida partida;

	public TareaContarSegundos(int estadoCuentaRegresiva, ProcesoTimerTurno timer, Partida partida) {
		this.estadoCuentaRegresiva = estadoCuentaRegresiva;
		this.timerJuego = timer;
		this.partida = partida;
	}

	@Override
	public void run() {
		if (estadoCuentaRegresiva >= 0){
			//System.out.println(estadoCuentaRegresiva/1000);
			estadoCuentaRegresiva -= 1000;
			partida.hayCambios();
			if (estadoCuentaRegresiva < 0){
				timerJuego.reset();
			}
		}
	}

	public int getEstado() {
		return (estadoCuentaRegresiva/1000);
	}


}
