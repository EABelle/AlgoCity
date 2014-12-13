package algocity.core.capas.catastrofes;

import java.util.Iterator;
import java.util.Random;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.procesadores.ProcesadorDeDaniados;

public class Terremoto extends Catastrofe {

	private static final double Paso = 1.5;
	private static final int MaximaCantidad = 3;

	static int cantidadPresentes;

	int origenX;
	int origenY;
	int radio;
	float danio;

	private boolean presente;


	public Terremoto(int x, int y) {
		origenX = x;
		origenY = y;
		inicializarVariables();
	}

	public Terremoto(Mapa mapa) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getFilas());
		origenY = rn.nextInt(mapa.getColumnas());
		inicializarVariables();
	}

	private void inicializarVariables() {
		danio = 50;
		radio = 0;
		cantidadPresentes ++;
		presente = true;
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

		while (((danio - Paso) > 0) && ((radioRestante --) >= 0)){
			danio -= Paso;
			radio ++;
			for(iter = mapa.RecorrerSoloEnUnRadio(radio, origenX, origenY);
				iter.hasNext();){
				hectarea = iter.next();
				hectarea.teImpacta(this);
				procesadorDeDanios.procesarDanios(mapa, hectarea);
			}
		}

		if (danio < Paso) {
			presente = false;
			cantidadPresentes --;
		}
	}

	@Override
	public boolean estaPresente() {
		return presente;
	}

	@Override
	public boolean continua() {
		return danio > 0;
	}

	public static void inicializar() {
		cantidadPresentes = 0;
	}

	public static boolean aparecer() {
		Random rm = new Random();
		int aparece = rm.nextInt(15);
		if ((cantidadPresentes < MaximaCantidad) && (aparece == 0)) {
			cantidadPresentes ++;
			return true;
		}
		return false;
	}

	public float getDanio() {
		return danio;
	}

}