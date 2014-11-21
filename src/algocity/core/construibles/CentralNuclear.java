package algocity.core.construibles;

public class CentralNuclear extends CentralElectrica {
	
	public CentralNuclear() {
		costo = 10000;
		radioDeAlimentacion = 25;
		capacidad = 1000;
		potenciaDisponible = capacidad;
		soyUn = "CentralNuclear";
	}
	
	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}
	
}