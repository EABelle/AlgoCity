package algocity.controladores;

import algocity.core.capas.Hectarea;
import algocity.vistas.VistaDeHerramienta;

public class ControladorDeElectricidad extends Herramienta {

	public ControladorDeElectricidad(VistaDeHerramienta vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		controladorPartida.getPartida().agregarRedDeAgua(
				hectarea.getFila(), hectarea.getColumna());
	}


}
