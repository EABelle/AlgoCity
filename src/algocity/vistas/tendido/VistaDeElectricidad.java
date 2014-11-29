package algocity.vistas.tendido;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.vistas.VistaDeHerramienta;

public class VistaDeElectricidad extends VistaDeHerramienta {

	public VistaDeElectricidad() {
		representacion = "e";
		estado = "Construir red electrica";
		costo = 5;
	}

	@Override
	public void procesarPartida(Partida partida, Hectarea hectarea) {
		partida.agregarRedElectrica(hectarea.getFila(), hectarea.getColumna());
	}

}
