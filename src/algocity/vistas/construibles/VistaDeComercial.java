package algocity.vistas.construibles;

import algocity.core.construibles.Comercial;
import algocity.core.construibles.Construible;

public class VistaDeComercial extends VistaDeConstruible {

	public VistaDeComercial() {
		representacion = "C";
		estado = "Agregar comercial";
		costo = new Comercial().getCosto();
		nombre = "Zona Comercial";
	}

	@Override
	public Construible getConstruible() {
		return new Comercial();
	}
}
