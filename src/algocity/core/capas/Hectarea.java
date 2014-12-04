package algocity.core.capas;

import java.util.Observable;

import algocity.core.Mapa;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.core.capas.catastrofes.Terremoto;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHectarea;

public abstract class Hectarea extends Observable {

	Construible construible;
	boolean conexionElectrica;
	int centralesCerca;
	boolean conexionRuta;
	boolean conexionAgua;
	int fila;
	int columna;
	RedDeAgua redDeAgua;

	public Hectarea() {
		construible = null;
		conexionAgua = false;
		conexionElectrica = false;
		conexionRuta = false;
		centralesCerca = 0;
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
			hayCambio();
			return true;
		}
		return false;
	}

	public boolean hayTendidoElectrico(){
		return conexionElectrica;
	}

	public boolean redElectricaConectada() {
		return conexionElectrica | (centralesCerca > 0);
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

	public boolean setCentralesCerca(boolean cerca) {
		if (cerca) {
			centralesCerca ++;
			hayCambio();
			return true;
		}else if (centralesCerca > 0) {
			centralesCerca --;
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

	public boolean redDeAguaConectada() {
		return conexionAgua;
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
		if (construible != null)
			construible.teImpacta(terremoto);
		hayCambio();
	}

	public void teImpacta(Godzilla godzy) {
		if (construible != null)
			construible.teImpacta(godzy);
		hayCambio();
	}

	public void procesarConexion(Mapa mapa) {
		if (construible != null) {
			construible.procesarConexion(mapa, fila, columna);
			hayCambio();
		}
	}

	public void procesarDesconexion(Mapa mapa) {
		if (construible != null) {
			construible.procesarDesconexion(mapa, fila, columna);
			hayCambio();
		}
	}

	public abstract void setTendidos(RedDeAgua redDeAgua, RedElectrica redElectrica);

}
