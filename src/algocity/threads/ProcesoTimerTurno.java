package algocity.threads;

import java.util.Timer;

import algocity.controladores.PasadorDeTurno;
import algocity.core.Partida;
import algocity.threads.timertasks.TareaContarSegundos;
import algocity.threads.timertasks.TareaPasarTurno;

public class ProcesoTimerTurno extends Thread {
	
	private TareaPasarTurno tareaPasarTurno;
	private PasadorDeTurno pasadorDeTurno;
	protected int TIEMPO = 60000; //milisegundos
	private Timer timer;
	private Timer cuentaRegresiva;
	private TareaContarSegundos contadorSegundos;
	private Partida partida;
	
	public ProcesoTimerTurno(PasadorDeTurno pasadorDeTurno, Partida partida) {
		this.pasadorDeTurno = pasadorDeTurno;
		this.partida = partida;
	}

	public void run(){
		
		try {
			
			timer = new Timer(true); // true = el timer corre como Demonio (DAEMON).
			tareaPasarTurno = new TareaPasarTurno(pasadorDeTurno);
			timer.scheduleAtFixedRate(tareaPasarTurno, TIEMPO, TIEMPO);
			
			
			cuentaRegresiva = new Timer(true);
			contadorSegundos = new TareaContarSegundos(TIEMPO, this, partida);
			cuentaRegresiva.scheduleAtFixedRate(contadorSegundos, 0, 1000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
		}
	}
	
	public void reset(){
		
		
		if (tareaPasarTurno != null){
			timer.cancel();
			cuentaRegresiva.cancel();			
			run();
		}
	}

	public int getTiempoRestante() {
		if (contadorSegundos != null)
			return contadorSegundos.getEstado();
		return 0;
	}
}