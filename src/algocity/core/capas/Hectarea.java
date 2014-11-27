package algocity.core.capas;

import java.util.Observable;

import algocity.core.capas.catastrofes.Godzilla;
import algocity.core.capas.catastrofes.Terremoto;
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

	public boolean setConexionAgua(boolean conexionAgua) {
		if (this.conexionAgua != conexionAgua) {
			this.conexionAgua = conexionAgua;
			hayCambio();
			return true;
		}
		return false;
	}

	public boolean setConexionElectrica(boolean conexionElectrica) {
		if (this.conexionElectrica != conexionElectrica) {
			this.conexionElectrica = conexionElectrica;
			hayCambio();
			return true;
		}
		return false;
	}

	public boolean setConexionRuta(boolean conexionRuta) {
		if (this.conexionRuta != conexionRuta) {
			this.conexionRuta = conexionRuta;
			hayCambio();
			return true;
		}
		return false;
	}

	public boolean conectarRedDeAgua() {
		if (!conexionAgua) {
			conexionAgua = true;
 			hayCambio();
 			return true;
		}
		return false;
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

	public void teImpacta(Terremoto terremoto) {
		construible.teImpacta(terremoto);
	}

	public void teImpacta(Godzilla godzy) {
		construible.teImpacta(godzy);
	}

}
