package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.vistas.VistaDeInfo;

public class Industrial extends Edificio {

	int puestosDisponibles;

	public Industrial() {
		costo = 10;
		consumo = 5;
		puestosDisponibles = 25;
	}

	public int puestosDeTrabajoOcupados() {
		return 25 - puestosDisponibles;
	}

	public int puestosDeTrabajoDisponibles() {
		return puestosDisponibles;
	}

	public boolean agregarTrabajadores(int cantidad) {
		if ((puestosDisponibles - cantidad) >= 0){
			puestosDisponibles -= cantidad;
			return true;
		}
		return false;
	}

	public boolean quitarTrabajadores(int cantidad) {
		if ((puestosDisponibles + cantidad) <= 25){
			puestosDisponibles += cantidad;
			return true;
		}
		return false;
	}

	@Override
	public boolean cumpleRequerimientos(boolean conexionAgua,
			boolean conexionRuta, boolean conexionElectrica){
		return conexionRuta & conexionElectrica;
	}

	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getHectareasIndustriales().add(mapa.getHectarea(x, y));
	}

	@Override
	public void teImpacta(Godzilla godzy) {
		godzy.impactame(this);
	}

	@Override
	public void mostrarInfo(VistaDeInfo vistaDeInfo) {
		vistaDeInfo.mostrarInfo(this);
	}

}