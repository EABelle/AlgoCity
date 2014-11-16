package algocity.core.construibles;

import algocity.core.Partida;

public class Industrial extends Edificio {
	
	public Industrial() {
		costo = 10;
		consumo = 5;
		redElectricaConectada = false;
		rutaPavimentadaConectada = false;
	}
	
	public void desconectarDeRedDeAgua(){
	}
	
	public void desconectarDeRedElectrica(){
		redElectricaConectada = false;		
	}
	
	public void desconectarDeRutaPavimentada(){
		rutaPavimentadaConectada = false;
	}

	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		redElectricaConectada = partida.redElectricaConectada(x, y);
	}
	
	public void procesarTurno(Partida partida, int x, int y) {
		redElectricaConectada = partida.redElectricaConectada(x, y);
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		if (daniado())
			partida.agregarDaniado(this, x, y);
	}
}