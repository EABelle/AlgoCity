package algocity.threads;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
}
