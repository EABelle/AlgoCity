package algocity.core.construibles;



public abstract class CentralElectrica extends ConstruibleEnLlano{
	int radioDeAlimentacion;
	int potencia;
	
	public CentralElectrica(){
		cumpleRedDeAgua = false;
	}
	
	public int getRadioDeAlimentacion() {
		return radioDeAlimentacion;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public void desconectarDeRedDeAgua(){
		cumpleRedDeAgua = false;
	}
	
	public void desconectarDeRedElectrica(){
		
	}
	
	public void desconectarDeRutaPavimentada(){
		
	}
	
	
	
	
}