package algocity.core.construibles;

public class CentralEolica extends CentralElectrica {

	public CentralEolica() {
		costo = 1000;
		radioDeAlimentacion = 4;
		capacidad = 100;
		potenciaDisponible = capacidad;
	}

	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}

	@Override
	public String getRepresentation() {
		return "Ce";
	}

}