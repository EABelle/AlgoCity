package algocity.threads.timertasks;

import java.io.File;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
public class TareaMusicaPartida extends TimerTask {

	
	Clip sonido; 
	
	@Override
	public void run() {
		try {
			sonido = AudioSystem.getClip();
			File tema = new File("files\\AUDIO01.wav");
			sonido.open(AudioSystem.getAudioInputStream(tema));
			long duracion = getDuracion();
			
			sonido.start();
			
			Thread.sleep(duracion);
			
			sonido.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}

	public long getDuracion() {
		try{
			return sonido.getMicrosecondLength()/1000;
		} catch (Exception e){
			return 0;
		}
	}

	public void playPauseMusic() {
		if (sonido == null)
			return;
		
		if (sonido.isActive())
			sonido.stop();
		else
			sonido.start();
	}
	
	
	
}
