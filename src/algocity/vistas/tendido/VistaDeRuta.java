package algocity.vistas.tendido;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.vistas.VistaDeHerramienta;

public class VistaDeRuta extends VistaDeHerramienta {

	public VistaDeRuta() {
		representacion = "r";
		estado = "Construir ruta";
		costo = 10;
	}

	@Override
	public void procesarPartida(Partida partida, Hectarea hectarea) {
		partida.agregarRutaPavimentada(hectarea.getX(), hectarea.getY());
	}

}
