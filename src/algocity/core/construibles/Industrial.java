package algocity.core.construibles;

import algocity.core.Partida;

public class Industrial extends Edificio {
	
	int puestosDisponibles;
	
	public Industrial() {
		costo = 10;
		consumo = 5;
		puestosDisponibles = 25;
		redElectricaConectada = false;
		rutaPavimentadaConectada = false;
		soyUn = "Industrial";
	}
	
	public boolean agregarTrabajadores(int cantidad) {
		if ((puestosDisponibles - cantidad) >= 0){
			puestosDisponibles -= cantidad;
			return true;
		}
		return false;
	}
	
	public void desconectarDeRedDeAgua() {
		redElectricaConectada = false;
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