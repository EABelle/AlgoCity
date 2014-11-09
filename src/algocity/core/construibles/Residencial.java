package algocity.core.construibles;

import algocity.core.EspacioInsuficienteException;
import algocity.core.NoHayTantosHabitantesException;

public class Residencial extends Edificio {
	
	static int costo = 5;
	static int consumo = 1;
	int habitantes;
	
	public Residencial() {
		habitantes = 0;
	}

	public void agregarHabitantes (int habitantesNuevos) throws EspacioInsuficienteException {
		if (habitantes + habitantesNuevos <= 100)
			habitantes += habitantesNuevos;
		else {
			throw new EspacioInsuficienteException();
		}
	}

	public int disponibilidad() {
		return 100 - habitantes;
	}

	public void quitarHabitantes (int habitantesSalientes) throws NoHayTantosHabitantesException {
		if ( (habitantes - habitantesSalientes) >= 0){
			habitantes-= habitantesSalientes;
		}else{
			throw new NoHayTantosHabitantesException();
		}
	}
}
