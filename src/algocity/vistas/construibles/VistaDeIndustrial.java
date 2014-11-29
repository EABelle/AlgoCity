package algocity.vistas.construibles;

import algocity.core.construibles.Construible;
import algocity.core.construibles.Industrial;

public class VistaDeIndustrial extends VistaDeConstruible {

	public VistaDeIndustrial() {
		representacion = "I";
		estado = "Agregar industrial";
		costo = new Industrial().getCosto();
	}

	@Override
	public Construible getConstruible() {
		return new Industrial();
	}
}
