package algocity.core;

import java.util.Timer;

import algocity.controladores.PasadorDeTurno;

public class ProcesoTimerTurno extends Thread {
	
	private TareaPasarTurno tareaPasarTurno;
	private PasadorDeTurno pasadorDeTurno;
	protected int TIEMPO = 10000; //milisegundos
	private Timer timer;
	private Timer cuentaRegresiva;
	private TareaContarSegundos contadorSegundos;
	
	public ProcesoTimerTurno(PasadorDeTurno pasadorDeTurno) {
		this.pasadorDeTurno = pasadorDeTurno;
	}

	public void run(){
		
		try {
			
			timer = new Timer(true); // true = el timer corre como Demonio (DAEMON).
			tareaPasarTurno = new TareaPasarTurno(pasadorDeTurno);
			timer.scheduleAtFixedRate(tareaPasarTurno, TIEMPO, TIEMPO);
			
			
			cuentaRegresiva = new Timer(true);
			contadorSegundos = new TareaContarSegundos(TIEMPO, this);
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