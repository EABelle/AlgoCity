package algocity.core.construibles;

public class CentralNuclear extends CentralElectrica {
	
	public CentralNuclear() {
		costo = 10000;
		radioDeAlimentacion = 25;
		capacidad = 1000;
		potenciaDisponible = capacidad;
	}
	
	public void pasanLosBomberos() {		
		this.reparar(10);
	}
}