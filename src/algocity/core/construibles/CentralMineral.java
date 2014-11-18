package algocity.core.construibles;

public class CentralMineral extends CentralElectrica {
	
	public CentralMineral() {
		costo = 3000;
		radioDeAlimentacion = 10;
		capacidad = 400;
		potenciaDisponible = capacidad;
	}
	
	public void pasanLosBomberos() {		
		this.reparar(10);
	}
	
}