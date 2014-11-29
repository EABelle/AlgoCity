package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		controladorPartida.procesarClick(hectarea);
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

	public void setRepresentacion(String repr) {
		this.vistaDeHectarea.setConstruible(repr);
	}

}
