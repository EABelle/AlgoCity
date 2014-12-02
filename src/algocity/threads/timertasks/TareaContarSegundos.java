package algocity.threads.timertasks;

import java.util.Timer;
import java.util.TimerTask;

import algocity.threads.ProcesoTimerTurno;

public class TareaContarSegundos extends TimerTask {

	private int estadoCuentaRegresiva;
	private ProcesoTimerTurno timerJuego;

	public TareaContarSegundos(int estadoCuentaRegresiva, ProcesoTimerTurno timer) {
		this.estadoCuentaRegresiva = estadoCuentaRegresiva;
		this.timerJuego = timer;
	}

	@Override
	public void run() {
		if (estadoCuentaRegresiva >= 0){
			System.out.println(estadoCuentaRegresiva/1000);
			estadoCuentaRegresiva -= 1000;
			if (estadoCuentaRegresiva < 0){
				timerJuego.reset();
			}
		}
	}

	public int getEstado() {
		return (estadoCuentaRegresiva/1000);
	}


}
