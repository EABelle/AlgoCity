package algocity.core.construibles;

public class Comercial extends Edificio {
	
	public Comercial() {
		costo = 5;
		consumo = 2;
		cumpleRedDeAgua = false;
		cumpleRedElectrica = false;
		cumpleRutaPavimentada = false;
	}
	
	public void desconectarDeRedDeAgua(){
		cumpleRedDeAgua = false;
	}
	
	public void desconectarDeRedElectrica(){
		cumpleRedElectrica = false;		
	}
	
	public void desconectarDeRutaPavimentada(){
		cumpleRutaPavimentada = false;
	}
	
}