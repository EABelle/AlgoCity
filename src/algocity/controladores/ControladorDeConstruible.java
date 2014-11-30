package algocity.controladores;

import algocity.core.capas.Hectarea;
import algocity.vistas.construibles.VistaDeConstruible;

public class ControladorDeConstruible extends Herramienta {

	public ControladorDeConstruible(VistaDeConstruible vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	public VistaDeConstruible getVistaConstruible() {
		return (VistaDeConstruible) vistaHerramienta;
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		VistaDeConstruible vistaDeConstruible = getVistaConstruible();
		controladorPartida.agregarConstruible(vistaDeConstruible.getConstruible(),
				hectarea.getFila(), hectarea.getColumna());
	}

	public String getRepresentacion() {
		return getVistaConstruible().getRepresentacion();
	}

	@Override
	public String getEstado() {
		return getVistaConstruible().getEstado();
	}

	@Override
	public void procesarBorradoHectarea(Hectarea hectarea) {
		if (controladorPartida.getPartida().quitarConstruible(
				hectarea.getFila(), hectarea.getColumna()))
			controladorPartida.setMensaje("Borradisimo");
		else
			controladorPartida.setMensaje("No se puede borrar!");
	}

}
