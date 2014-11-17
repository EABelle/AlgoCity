package algocity.core.construibles;

import algocity.core.Partida;

public class EstacionDeBombero extends ConstruibleEnLlano {
		
	public EstacionDeBombero() {
		rutaPavimentadaConectada = false;
	}
	
	public void reparar(Construible daniado) {
		daniado.pasanLosBomberos();		
	}

	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		partida.agregarEstacionDeBomberos(x, y);
		
	}

}
