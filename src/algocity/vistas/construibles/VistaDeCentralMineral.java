package algocity.vistas.construibles;

import algocity.core.construibles.CentralMineral;
import algocity.core.construibles.Construible;

public class VistaDeCentralMineral extends VistaDeConstruible {

	public VistaDeCentralMineral() {
		representacion = "Cm";
		estado = "Agregar Central Mineral";
	}

	@Override
	public Construible getConstruible() {
		return new CentralMineral();
	}
}
