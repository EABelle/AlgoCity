package algocity.core;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ProcesoMusicaPartida extends Thread {
	
	String mensaje;
	
	public ProcesoMusicaPartida(String mensaje){
		super(mensaje);
	}
	
	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}
	
	public void run(){
		try {
			
			
			Timer timer = new Timer(true); // true = el timer corre como Demonio (DAEMON).
			TareaMusicaPartida reproductor = new TareaMusicaPartida();
			long duracion = reproductor.getDuracion();
			timer.scheduleAtFixedRate(reproductor, 0, duracion + 100);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
		}
		
		
	}
}
