package algocity.core;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import algocity.core.capas.Hectarea;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.core.capas.catastrofes.Terremoto;
import algocity.core.construibles.Construible;
import algocity.core.procesadores.CalculadorDeCalidadDeVida;
import algocity.core.procesadores.Debitador;
import algocity.core.procesadores.ProcesadorDeBomberos;
import algocity.core.procesadores.Refrescador;


public class Partida extends Observable {

	protected Mapa mapa;
	protected int turno;
	int plata;
	Godzilla godzy;
	Terremoto terremoto;
	static int TIEMPO = 5; //en segundos
	boolean inicializada;


	public Partida (Mapa mapa) {
		this.mapa = mapa;
		inicializada = false;
		godzy = null;
		terremoto = null;
	}

	public void inicializar() {
		turno = 0;
		plata = Configuracion.PlataInicial;
		inicializada = true;
	}

	public boolean inicializada() {
		return inicializada;
	}
	
	public int getPlata(){
		return plata;
	}

	public boolean agregarConstruible(Construible construible, int x, int y) {
		if (plata >= construible.getCosto() &&
				mapa.agregarConstruible(construible, x, y)) {
			construible.procesarAgregado(mapa, x, y);
			cobrar(construible.getCosto());
			return true;
		}
		return false;
	}

	public boolean quitarConstruible(int x, int y) {
		Construible construible = mapa.getHectarea(x, y).getConstruible();
		if (mapa.borrarConstruible(x, y)){
			construible.procesarBorrado(mapa, x, y);
			return true;
		}
		return false;
	}

	public boolean agregarRutaPavimentada(int x, int y) {
		if (mapa.getRutaPavimentada().getCosto() > plata)
			return false;
		if (!mapa.getRutaPavimentada().agregarNodo(x, y))
			return false;
		if (!mapa.getHectarea(x, y).setConexionRuta(true)){
			mapa.getRutaPavimentada().eliminarNodo(x, y);
			return false;
		}
		cobrar(mapa.getRutaPavimentada().getCosto());
		mapa.getHectarea(x, y).procesarConexion(mapa);
		return true;

	}

	public boolean quitarRutaPavimentada(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.rutaPavimentadaConectada()){
			mapa.getRutaPavimentada().eliminarNodo(x, y);
			hectarea.setConexionRuta(false);
			hectarea.procesarDesconexion(mapa);
			return true;
		}
		return false;
	}

	public boolean agregarRedElectrica(int x, int y) {
		if (mapa.getRedElectrica().getCosto() > plata)
			return false;
		if (!mapa.getRedElectrica().agregarNodo(x, y))
			return false;
		if (!mapa.getHectarea(x, y).setConexionElectrica(true)){
			mapa.getRedElectrica().eliminarNodo(x, y);
			return false;
		}
		cobrar(mapa.getRedElectrica().getCosto());
		mapa.getHectarea(x, y).procesarConexion(mapa);
		return true;
	}


	public boolean quitarRedElectrica(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.setConexionElectrica(false)){
			mapa.getRedElectrica().eliminarNodo(x, y);
			hectarea.procesarDesconexion(mapa);
			return true;
		}
		return false;
	}

	public boolean agregarRedDeAgua(int x, int y) {
		if (mapa.getRedDeAgua().getCosto() > plata)
			return false;
		if (!mapa.getRedDeAgua().agregarNodo(x, y))
			return false;
		if (!mapa.getHectarea(x, y).setConexionAgua(true)){
			mapa.getRedDeAgua().eliminarNodo(x, y);
			return false;
		}
		cobrar(mapa.getRedDeAgua().getCosto());
		mapa.getHectarea(x, y).procesarConexion(mapa);
		return true;

	}

	public boolean quitarRedDeAgua(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.setConexionAgua(false)) {
			mapa.getRedDeAgua().eliminarNodo(x, y);
			hectarea.procesarDesconexion(mapa);
			return true;
		}
		return false;
	}
	
	private void cobrar(int costo) {
		plata -= costo;
		hayCambios();
	}

	public void pasarTurno() {
		turno ++;
		if ((turno % 30) == 0){
			Debitador debitador = new Debitador(mapa);
			plata += debitador.getPago();
		}
		Refrescador.refresh(mapa);
		ProcesadorDeBomberos.procesar(mapa);
		CalculadorDeCalidadDeVida.procesar(mapa) ;
		hayCambios();
	}

	public void jugar() {
		int turno = 0;
		while(turno < Configuracion.TurnoMaximo) {
			this.pasarTurno();
			turno++;
		}
	}

	public Mapa getMapa() {
		return mapa;
	}

	private boolean generarGodzilla() {
		Random rn = new Random();
		return (rn.nextBoolean() & rn.nextBoolean() & rn.nextBoolean());
	}

	public int getTurno() {
		return turno;
	}

	public void hayCambios() {
		setChanged();
		notifyObservers();
	}
}