package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHectarea;

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
			controladorPartida.agregarConstruible(cons,
					hectarea.getFila(), hectarea.getColumna());
		}
	}

}
