package algocity.core.construibles;

public class CentralMineral extends CentralElectrica {
	
	public CentralMineral() {
		costo = 3000;
		radioDeAlimentacion = 10;
		potencia = 400;
	}
	
	public void pasanLosBomberos() {		
		this.reparar(10);
	}
	
}