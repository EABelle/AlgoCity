package algocity.core.construibles;

import algocity.core.Configuracion;
import algocity.core.exceptions.EspacioInsuficienteException;
import algocity.core.exceptions.NoHayTantosHabitantesException;
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

	public void agregarHabitantes (int habitantesNuevos) throws EspacioInsuficienteException {
		if ((habitantes + habitantesNuevos <= Configuracion.MaximoHabitantes) && cumpleRequerimientos())
			habitantes += habitantesNuevos;
		else {
			throw new EspacioInsuficienteException();
		}
	}

	public int disponibilidad() {
		return Configuracion.MaximoHabitantes - habitantes;
	}

	public void quitarHabitantes (int habitantesSalientes) throws NoHayTantosHabitantesException {
		if ( (habitantes - habitantesSalientes) >= 0){
			habitantes-= habitantesSalientes;
		}else{
			throw new NoHayTantosHabitantesException();
		}
	}
	
}