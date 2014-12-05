package algocity.threads;

import java.util.Timer;

import algocity.controladores.PasadorDeTurno;
import algocity.core.Partida;
import algocity.threads.timertasks.TareaContarSegundos;

public class ProcesoTimerTurno extends Thread {
	
	protected int DURACION = 60000; //milisegundos
	private int tiempoRestanteEnPausa;
	private Timer cuentaRegresiva;
	private TareaContarSegundos contadorSegundos;
	private Partida partida;
	private boolean corriendo;
	
	public ProcesoTimerTurno(PasadorDeTurno pasadorDeTurno, Partida partida) {
		this.partida = partida;
		this.corriendo = false;
		this.tiempoRestanteEnPausa = DURACION;
	}

	public void run(){
		
		try {
			cuentaRegresiva = new Timer(true);
			contadorSegundos = new TareaContarSegundos(tiempoRestanteEnPausa, this, partida);
			cuentaRegresiva.scheduleAtFixedRate(contadorSegundos, 0, 1000);
			
			this.corriendo = true;
			
			tiempoRestanteEnPausa = DURACION;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
		}
	}
	
	public void reset(){
		cuentaRegresiva.cancel();			
		run();
	}

	public int getTiempoRestante() {
		if (contadorSegundos != null)
			return contadorSegundos.getEstado();
		return 0;
	}
	
	public void playPause(){
		if (cuentaRegresiva == null)
			return;
		if (this.corriendo){
			cuentaRegresiva.cancel();;
			this.corriendo = false;
			tiempoRestanteEnPausa = getTiempoRestante()*1000;
			
		}
		else{
			run();
		}
	}
}