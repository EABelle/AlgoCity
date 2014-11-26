package algocity.core.capas;

import java.util.Observable;

import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHectarea;

public abstract class Hectarea extends Observable {

	Construible construible;
	boolean conexionElectrica;
	boolean conexionRuta;
	boolean conexionAgua;
	int fila;
	int columna;

	public Hectarea() {
		construible = null;
		conexionAgua = false;
		conexionElectrica = false;
		conexionRuta = false;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}


	public abstract boolean agregarConstruible(Construible construible);

	public boolean borrarConstruible(){
		if (construible != null){
			construible = null;
			return true;
		}
		return false;
	}
	
	public void conectarRedElectrica() {
		conexionElectrica = true;
	}

	public void desconectarRedElectrica(){
		conexionElectrica = false;
	}
	
	public boolean redElectricaConectada() {
		return conexionElectrica ;
	}

	public void conectarRedDeAgua() {
		conexionAgua= true;
	}

	public void desconectarRedDeAgua(){
		conexionAgua = false;
	}

	public boolean redDeAguaConectada() {
		return conexionAgua;
	}

	public void conectarRutaPavimentada() {
		conexionRuta = true;
	}

	public void desconectarRutaPavimentada(){
		conexionRuta = false;
	}
	
	public boolean rutaPavimentadaConectada() {
		return conexionRuta;
	}
	
	public Construible getConstruible() {
		return construible;
	}

	public void impactar(float danio) {
		if (construible != null)
			construible.daniar(danio);
	}

	public abstract void dibujarse(VistaDeHectarea vistaDeHectarea);

	public void hayCambio() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	public void procesarTurno(Partida partida, int x, int y) {
		if (construible != null)
			construible.procesarTurno(partida, x, y);

	}

	public void mandarBomberoHasta(Arreglable daniado) {
		((EstacionDeBombero)construible).reparar(daniado);
	}
*/


}
