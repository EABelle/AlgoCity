package algocity.controladores;

import algocity.core.capas.Hectarea;
import algocity.vistas.tendido.VistaDeRuta;

public class ControladorDeRuta extends Herramienta {

	public ControladorDeRuta(VistaDeRuta vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		controladorPartida.getPartida().agregarRutaPavimentada(
				hectarea.getFila(), hectarea.getColumna());
	}

	@Override
	public String getEstado() {
		return "Construir ruta";
	}



}
