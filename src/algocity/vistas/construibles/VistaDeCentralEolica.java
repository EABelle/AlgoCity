package algocity.vistas.construibles;

import algocity.core.construibles.CentralEolica;
import algocity.core.construibles.Construible;

public class VistaDeCentralEolica extends VistaDeConstruible {

	public VistaDeCentralEolica() {
		representacion = "Ce";
		estado = "Agregar Central Eolica";
		costo = new CentralEolica().getCosto();
		nombre = "Central Eólica";
	}

	@Override
	public Construible getConstruible() {
		return new CentralEolica();
	}
}
