package algocity.vistas.construibles;

import algocity.core.construibles.Construible;
import algocity.core.construibles.PozoDeAgua;

public class VistaDePozoDeAgua extends VistaDeConstruible {

	public VistaDePozoDeAgua() {
		representacion = "P";
		estado = "Agregar pozo de agua";
	}

	@Override
	public Construible getConstruible() {
		return new PozoDeAgua();
	}
}
