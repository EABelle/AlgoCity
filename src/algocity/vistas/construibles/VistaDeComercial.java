package algocity.vistas.construibles;

import algocity.core.construibles.Comercial;
import algocity.core.construibles.Construible;

public class VistaDeComercial extends VistaDeConstruible {

	public VistaDeComercial() {
		representation = "C";
		estado = "Agregar comercial";
	}

	@Override
	public Construible getConstruible() {
		return new Comercial();
	}
}
