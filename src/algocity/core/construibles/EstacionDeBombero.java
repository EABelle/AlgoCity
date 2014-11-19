package algocity.core.construibles;

import algocity.core.Partida;

public class EstacionDeBombero extends ConstruibleEnLlano {
		
	public EstacionDeBombero() {
		rutaPavimentadaConectada = false;
	}
	
	public void reparar(Construible daniado) {
		if (daniado.tipo().compareTo("Residencial") == 0) {
			daniado.reparar(10);
		}else if (daniado.tipo().compareTo("Comercial") == 0){
			daniado.reparar(7);
		}else if (daniado.tipo().compareTo("Industrial") == 0){
			daniado.reparar(3);
		}else if (daniado.tipo().compareTo("CentralEolica") == 0){
			daniado.reparar(15);
		}else if (daniado.tipo().compareTo("CentralMineral") == 0){
			daniado.reparar(10);
		}else if (daniado.tipo().compareTo("CentralNuclear") == 0){
			daniado.reparar(3);
		}
	}

	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		partida.agregarEstacionDeBomberos(x, y);
	}

}
