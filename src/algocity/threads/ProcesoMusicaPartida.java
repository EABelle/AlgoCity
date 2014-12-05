package algocity.threads;

import java.util.Timer;
import algocity.threads.timertasks.TareaMusicaPartida;

public class ProcesoMusicaPartida extends Thread {
	
	TareaMusicaPartida reproductor;
	
	public void run(){
		try {
			
			Timer timer = new Timer(true); // true = el timer corre como Demonio (DAEMON).
			reproductor = new TareaMusicaPartida();
			long duracion = reproductor.getDuracion();
			timer.scheduleAtFixedRate(reproductor, 0, duracion + 100);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
		}
		
		
	}

	public void playPauseMusic() {
		
		reproductor.playPauseMusic();
	}

	public boolean estaCorriendo() {

		return reproductor.estaCorriendo();
	}
}
