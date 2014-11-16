package algocity.core.construibles;

import algocity.core.Partida;



public abstract class CentralElectrica extends ConstruibleEnLlano{
	int radioDeAlimentacion;
	int potencia;
	
	public CentralElectrica(){
		redDeAguaConectada = false;
	}
	
	public int getRadioDeAlimentacion() {
		return radioDeAlimentacion;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public void desconectarDeRedDeAgua(){
		redDeAguaConectada = false;
	}
	
	public void desconectarDeRedElectrica(){
		
	}
	
	public void desconectarDeRutaPavimentada(){
		
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
	
	
	
	
}