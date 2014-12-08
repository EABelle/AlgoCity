package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeHectarea;
import algocity.vistas.VistaDeInfo;

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
		controladorPartida.setControladorDeHectarea(this);
		if (SwingUtilities.isRightMouseButton(e)) {
			controladorPartida.procesarClickDerecho(hectarea);
		} else if (SwingUtilities.isLeftMouseButton(e)) {
			controladorPartida.procesarClick(hectarea);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Construible cons = hectarea.getConstruible();
		VistaDeInfo vista = controladorPartida.getVistaDeInfo();
		if (cons != null) {
			cons.mostrarInfo(vista);
		} else {
			vista.setInfo("-");
		}
	}

}
