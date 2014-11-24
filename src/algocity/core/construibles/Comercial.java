package algocity.core.construibles;

public class Comercial extends Edificio {
	
	public Comercial() {
		costo = 5;
		consumo = 2;

	}
	
	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}
	
}