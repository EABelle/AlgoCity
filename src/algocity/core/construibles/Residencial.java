package algocity.core.construibles;

import algocity.core.Configuracion;
public class Residencial extends Edificio {

	int habitantes;

	public Residencial() {
		habitantes = 0;
		costo = 5;
		consumo = 1;
		redDeAguaConectada = false;
		redElectricaConectada = false;
		rutaPavimentadaConectada = false;
		soyUn = "Residencial";
	}

	public boolean agregarHabitantes (int habitantesNuevos) {
		if ((habitantes + habitantesNuevos <= Configuracion.MaximoHabitantes) && cumpleRequerimientos()) {
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

}