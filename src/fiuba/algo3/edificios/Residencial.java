package fiuba.algo3.edificios;

import fiuba.algo3.EspacioInsuficiente;
import fiuba.algo3.NoHayTantosHabitantes;

public class Residencial extends Edificio {
	int habitantes;
	
	public void Residencial (){
		Edificio (5, 1);
		habitantes = 0;
	}

	public void agregarHabitantes (int habitantesNuevos) throws EspacioInsuficiente{
		if (habitantes + habitantesNuevos <= 100)
			habitantes+= habitantesNuevos;
		else {
			throw new EspacioInsuficiente();
		}
	}

	public int disponibilidad() {
		return 100 - habitantes;
	}

	public void quitarHabitantes (int habitantesSalientes) throws NoHayTantosHabitantes {
		if ( (habitantes - habitantesSalientes) >= 0){
			habitantes-= habitantesSalientes;
		}else{
			throw new NoHayTantosHabitantes();
		}
	}
}
