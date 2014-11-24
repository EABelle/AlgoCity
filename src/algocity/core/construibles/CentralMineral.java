package algocity.core.construibles;

public class CentralMineral extends CentralElectrica {
	
	public CentralMineral() {
		costo = 3000;
		radioDeAlimentacion = 10;
		capacidad = 400;
		potenciaDisponible = capacidad;
	}
	
	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}
	
}