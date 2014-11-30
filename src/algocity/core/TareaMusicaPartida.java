package algocity.core;

import java.util.TimerTask;

import javax.sound.sampled.Clip;
public class TareaMusicaPartida extends TimerTask {

	
	Clip sonido; 
	
	@Override
	public void run() {
		if (sonido != null){
			sonido.start();
			long duracion = sonido.getMicrosecondLength()/1000;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sonido.stop();
			
		}
			
	}
	
	public void setSonido(Clip sonido){
		this.sonido = sonido;
	}
	
	
	
}
