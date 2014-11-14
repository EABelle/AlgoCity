package algocity.core.construibles;

public class Industrial extends Edificio {
	
	public Industrial() {
		costo = 10;
		consumo = 5;
		cumpleRedElectrica = false;
		cumpleRutaPavimentada = false;
	}
	
	public void desconectarDeRedDeAgua(){
	}
	
	public void desconectarDeRedElectrica(){
		cumpleRedElectrica = false;		
	}
	
	public void desconectarDeRutaPavimentada(){
		cumpleRutaPavimentada = false;
	}
}