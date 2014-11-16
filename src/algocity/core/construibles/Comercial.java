package algocity.core.construibles;

public class Comercial extends Edificio {
	
	public Comercial() {
		costo = 5;
		consumo = 2;
		redDeAguaConectada = false;
		redElectricaConectada = false;
		rutaPavimentadaConectada = false;
	}
	
	public void desconectarDeRedDeAgua(){
		redDeAguaConectada = false;
	}
	
	public void desconectarDeRedElectrica(){
		redElectricaConectada = false;		
	}
	
	public void desconectarDeRutaPavimentada(){
		rutaPavimentadaConectada = false;
	}
		
}