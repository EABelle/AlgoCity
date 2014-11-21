package algocity.core.construibles;

import algocity.core.Partida;

public abstract class CentralElectrica extends ConstruibleEnLlano implements Arreglable{

	int radioDeAlimentacion;
	int capacidad;
	int potenciaDisponible;
	
	public CentralElectrica(){
		redDeAguaConectada = false;
	}
	
	public int getRadioDeAlimentacion() {
		return radioDeAlimentacion;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public int getPotenciaDisponible() {
		return potenciaDisponible;
	}
	
	public void desconectarDeRedDeAgua(){
		redDeAguaConectada = false;
	}
	
	public void procesarAgregado(Partida partida, int x, int y)  {
			
		int i;
		int j;
				
		partida.agregarCentralElectrica(x, y);
				
		for(i = 0; i <= 2 * radioDeAlimentacion; i++) {
			for (j = 0; j <= 2 * radioDeAlimentacion; j++) {
				if(((x - radioDeAlimentacion + i) >= 0 ) && 
					((x - radioDeAlimentacion + i) < partida.getfilas()) && ((y - radioDeAlimentacion + j) >= 0) && ((y - radioDeAlimentacion + j) <partida.getcolumnas()))
					partida.conectarRedElectrica(x - radioDeAlimentacion + i, y - radioDeAlimentacion + j);
			}
		}
	}
	
	public void procesarTurno(Partida partida, int x, int y) {
		redDeAguaConectada = partida.redDeAguaConectada(x, y);
		if (daniado())
			partida.agregarDaniado(this, x, y);
	}

	public boolean restarPotencia(int consumo) {
		if (potenciaDisponible - consumo < 0)
			return false;
		potenciaDisponible -= consumo;
		return true;
		
	}
	
}