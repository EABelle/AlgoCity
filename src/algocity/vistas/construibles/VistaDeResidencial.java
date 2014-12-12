package algocity.vistas.construibles;

import algocity.core.construibles.Construible;
import algocity.core.construibles.Residencial;

public class VistaDeResidencial extends VistaDeConstruible {

	public VistaDeResidencial() {
		representacion = "R";
		estado = "Agregar residencial";
		costo = new Residencial().getCosto();
		nombre = "Zona Residencial";
	}

	@Override
	public Construible getConstruible() {
		return new Residencial();
	}

}
