package algocity.core.construibles;

import algocity.core.Configuracion;
import algocity.core.Mapa;
import algocity.core.procesadores.ProcesadorDeAgregado;
import algocity.core.procesadores.ProcesadorDeResidencial;
public class Residencial extends Edificio {

	int habitantes;

	public Residencial() {
		habitantes = 0;
		costo = 5;
		consumo = 1;
}

	public boolean agregarHabitantes (int habitantesNuevos) {
		if (habitantes + habitantesNuevos <= Configuracion.MaximoHabitantes)  {
			habitantes += habitantesNuevos;
			return true;
		}
		return false;
	}

	public int disponibilidad() {
		return Configuracion.MaximoHabitantes - habitantes;
	}

	public boolean quitarHabitantes (int habitantesSalientes) {
		if ( (habitantes - habitantesSalientes) >= 0) {
			habitantes -= habitantesSalientes;
			return true;
		}
		return false;
	}

	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}

	@Override
	public ProcesadorDeAgregado getProcesador(Mapa mapa, int x, int y) {
		ProcesadorDeResidencial procesador = new ProcesadorDeResidencial(mapa, x, y);
		procesador.setResidencial(this);
		return procesador;
	}

}