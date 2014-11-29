package algocity.controladores;

import java.awt.event.MouseEvent;

import algocity.core.capas.Hectarea;
import algocity.vistas.construibles.VistaDeConstruible;

public class ControladorDeConstruible extends Herramienta {


	public ControladorDeConstruible(VistaDeConstruible vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	public VistaDeConstruible getVistaConstruible() {
		return (VistaDeConstruible) vistaHerramienta;
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		VistaDeConstruible vistaDeConstruible = getVistaConstruible();
		if (controladorPartida.agregarConstruible(vistaDeConstruible.getConstruible(),
				hectarea.getFila(), hectarea.getColumna()))
			this.controladorPartida.setEstado(vistaDeConstruible.getEstado());
	}

	public String getRepresentacion() {
		return getVistaConstruible().getRepresentacion();
	}

}
