package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.core.capas.Hectarea;
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
		controladorPartida.setControladorDeHectarea(this);
		controladorPartida.procesarClick(hectarea);
	}

	public void setRepresentacion(String repr) {
		this.vistaDeHectarea.setConstruible(repr);
	}

}
