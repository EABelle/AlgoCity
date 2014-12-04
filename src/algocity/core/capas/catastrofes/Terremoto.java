package algocity.core.capas.catastrofes;

import java.util.Iterator;
import java.util.Random;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.core.procesadores.ProcesadorDeDaniados;

public class Terremoto extends Catastrofe {
	int origenX;
	int origenY;
	float danio;
	int radio;
	static int cantidadPresentes;
	

	public Terremoto(int x, int y) {
		origenX = x;
		origenY = y;
		danio = 50;
		radio=0;
		cantidadPresentes ++;
	}
	
	public Terremoto(Mapa mapa) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getFilas());
		origenY = rn.nextInt(mapa.getColumnas());
		
	}

	@Override
	public void procesar(Mapa mapa) {
		int radioRestante = 17; //para que dure 3 turnos
		Hectarea hectarea;
		Iterator<Hectarea> iter;
		ProcesadorDeDaniados procesadorDeDanios = new ProcesadorDeDaniados();
		
		if(radio == 0) {
			hectarea = mapa.getHectarea(origenX, origenY);
			hectarea.teImpacta(this);
			procesadorDeDanios.procesarDanios(mapa, hectarea);
			radioRestante --;
		}
		while (((danio - 1.5) > 0) && ((radioRestante --) >= 0)){
			danio -= 1.5;
			radio ++;
			for(iter = mapa.RecorrerSoloEnUnRadio(radio, origenX, origenY);
				iter.hasNext();){
				hectarea = iter.next();
				hectarea.teImpacta(this);
				procesadorDeDanios.procesarDanios(mapa, hectarea);
			}
		}
		
		if (danio <= 0) {
			cantidadPresentes --;
		}
	}
	
	public void impactame(Construible construible){
		construible.daniar(danio);
	}

	@Override
	public boolean continua() {
		return danio > 0;
	}

	public static void inicializar() {
		cantidadPresentes = 0;
	}

}