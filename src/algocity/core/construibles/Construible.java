package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.core.capas.catastrofes.Terremoto;
import algocity.vistas.VistaDeInfo;
public abstract class Construible {

	protected int costo;
	protected float porcentajeDeVida;

	public Construible() {
		porcentajeDeVida = 100;
	}

	public int getCosto() {
		return costo;
	}

	public float getPorcetajeDeVida() {
		return porcentajeDeVida;
	}

	public void daniar (float porcentajeDeDanio) {
	}

	public void reparar (float porcentajeDeReparo) {
	}

	public boolean cumpleRequerimientos(boolean conexionAgua,
			boolean conexionRuta, boolean conexionElectrica){
		return true;
	}

	public boolean daniado() {
		return porcentajeDeVida != 100;
	}

	public void procesarAgregado(Mapa mapa, int x, int y) {

	}

	public void procesarBorrado(Mapa mapa, int x, int y) {
		
	}

	public void teImpacta(Terremoto terremoto) {

	}

	public void teImpacta(Godzilla godzy) {

	}

	public void mostrarInfo(VistaDeInfo vistaDeInfo) {}

	public void procesarConexion(Mapa mapa, int x, int y) {
		
	}

	public void procesarDesconexion(Mapa mapa, int fila, int columna) {
				
	}
}