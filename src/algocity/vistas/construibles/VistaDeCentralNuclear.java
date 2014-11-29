package algocity.vistas.construibles;

import algocity.core.construibles.CentralNuclear;
import algocity.core.construibles.Construible;

public class VistaDeCentralNuclear extends VistaDeConstruible {

	public VistaDeCentralNuclear() {
		representacion = "Cn";
		estado = "Agregar Central Nuclear";
		costo = new CentralNuclear().getCosto();
	}

	@Override
	public Construible getConstruible() {
		return new CentralNuclear();
	}
}
