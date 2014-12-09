package algocity.vistas.construibles;

import algocity.controladores.ControladorDeConstruible;
import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHerramienta;

public abstract class VistaDeConstruible extends VistaDeHerramienta {

	public abstract Construible getConstruible();

	public void agregarControladorDeMouse(ControladorDeConstruible controlador) {
		addMouseListener(controlador);
	}

	@Override
	public void procesarPartida(Partida partida, Hectarea hectarea) {
		partida.agregarConstruible(this.getConstruible(),
				hectarea.getX(), hectarea.getY());
	}

}
