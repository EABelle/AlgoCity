package algocity.core.capas;

import algocity.core.Partida;
import algocity.core.construibles.Arreglable;
import algocity.core.construibles.Construible;
import algocity.core.construibles.EstacionDeBombero;

public abstract class Hectarea  {

	Construible construible;
	boolean conexionElectrica;
	boolean conexionRuta;
	boolean conexionAgua;

	public Hectarea() {
		construible = null;
		conexionAgua = false;
		conexionElectrica = false;
		conexionRuta = false;
	}

	public abstract boolean agregarConstruible(Construible construible);

	public boolean redElectricaConectada() {
		return conexionElectrica ;
	}

	public boolean redDeAguaConectada() {
		return conexionAgua;
	}

	public boolean rutaPavimentadaConectada() {
		return conexionRuta;
	}


	public void conectarRedElectrica() {
		conexionElectrica = true;
	}

	public void desconectarRedElectrica(){
		conexionElectrica = false;;
	}

	public boolean borrarConstruible(){
		if (construible != null){
			construible = null;
			return true;
		}
		return false;
	}

	public void procesarTurno(Partida partida, int x, int y) {
		if (construible != null)
			construible.procesarTurno(partida, x, y);

	}

	public void mandarBomberoHasta(Arreglable daniado) {
		((EstacionDeBombero)construible).reparar(daniado);
	}

	public Construible getConstruible() {
		return construible;
	}

	public void impactar(float danio) {
		if (construible != null)
			construible.daniar(danio);
	}

	public String contieneUn() {
		return null;
	}


}
