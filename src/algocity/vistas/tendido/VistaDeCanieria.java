package algocity.vistas.tendido;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.vistas.VistaDeHerramienta;

public class VistaDeCanieria extends VistaDeHerramienta {

	public VistaDeCanieria() {
		representacion = "c";
		estado = "Construir cañeria";
	}

	@Override
	public void procesarPartida(Partida partida, Hectarea hectarea) {
		partida.agregarRedDeAgua(hectarea.getFila(), hectarea.getColumna());
	}


}
