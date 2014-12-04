package algocity.threads.timertasks;

import java.io.File;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class TareaMusicaPartida extends TimerTask {

	
	Clip sonido; 
	
	@Override
	public void run() {
		try {
			
			File tema = new File("files/AUDIO01.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(tema);
			AudioFormat format = stream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			sonido = (Clip)AudioSystem.getLine(info);
			
			sonido.open(stream);
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
