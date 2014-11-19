package algocity.core.construibles;

public class CentralEolica extends CentralElectrica {
	
	public CentralEolica() {
		costo = 1000;
		radioDeAlimentacion = 4;
		capacidad = 100;
		potenciaDisponible = capacidad;
		soyUn = "CentralEolica";
	}

}