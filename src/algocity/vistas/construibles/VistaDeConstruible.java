package algocity.vistas.construibles;

import algocity.controladores.ControladorEdificios;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHerramienta;

public abstract class VistaDeConstruible extends VistaDeHerramienta {

	public abstract Construible getConstruible();

	public void agregarControladorDeMouse(ControladorEdificios controlador) {
		addMouseListener(controlador);
	}

}
