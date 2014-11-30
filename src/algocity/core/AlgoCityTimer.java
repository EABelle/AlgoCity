package algocity.core;

import java.util.Date;
import java.util.TimerTask;

public class AlgoCityTimer extends TimerTask {

	static int TIEMPO = 5; //en segundos
	
	
	public void run() {
		System.out.println("Nuevo turno at:"+new Date());
	}
}
