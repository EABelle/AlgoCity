package algocity.core.construibles;

import algocity.core.EspacioInsuficienteException;
import algocity.core.NoHayTantosHabitantesException;

public class Residencial extends Edificio {
	int habitantes;
	
	public void Residencial (){
		Edificio (5, 1);
		habitantes = 0;
	}

	public void agregarHabitantes (int habitantesNuevos) throws EspacioInsuficienteException{
		if (habitantes + habitantesNuevos <= 100)
			habitantes+= habitantesNuevos;
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
