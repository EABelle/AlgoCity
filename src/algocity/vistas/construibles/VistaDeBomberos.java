package algocity.vistas.construibles;

import algocity.core.construibles.Construible;
import algocity.core.construibles.EstacionDeBombero;

public class VistaDeBomberos extends VistaDeConstruible {

	public VistaDeBomberos() {
		representacion = "B";
		estado = "Agregar bomberos";
	}

	@Override
	public Construible getConstruible() {
		return new EstacionDeBombero();
	}
}
