package algocity.controladores;

import algocity.core.capas.Hectarea;
import algocity.vistas.tendido.VistaDeCanieria;


public class ControladorDeCanieria extends Herramienta {

	public ControladorDeCanieria(VistaDeCanieria vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		if (controladorPartida.getPartida().agregarRedDeAgua(
				hectarea.getFila(), hectarea.getColumna()))
			controladorPartida.setMensaje("Construido");
		else
			controladorPartida.setMensaje("No se puede construir aca");
	}

	@Override
	public String getEstado() {
		return "Construir cañeria";
	}

}
