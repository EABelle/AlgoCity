package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHectarea;
import algocity.vistas.construibles.VistaDeConstruible;

public class ControladorHectarea extends MouseAdapter {


	private VistaDeHectarea vistaDeHectarea;
	private ControladorPartida controladorPartida;
	private Hectarea hectarea;

	public ControladorHectarea(Hectarea hectarea, VistaDeHectarea vistaDeHectarea,
			ControladorPartida controladorPartida) {
		this.vistaDeHectarea = vistaDeHectarea;
		this.controladorPartida = controladorPartida;
		this.hectarea = hectarea;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Construible cons = controladorPartida.getConstruible();
		if (cons != null) {
			if (!controladorPartida.agregarConstruible(
				cons, hectarea.getFila(), hectarea.getColumna())) {
				controladorPartida.setMensaje("No se puede construir aca");
			} else {
				VistaDeConstruible vistaConstruible = controladorPartida.getVistaConstruible();
				vistaDeHectarea.setConstruible(vistaConstruible.getRepresentacion());
				controladorPartida.setMensaje("Construidisimo");
				controladorPartida.actualizarPlata();
			}
		}
	}

}
