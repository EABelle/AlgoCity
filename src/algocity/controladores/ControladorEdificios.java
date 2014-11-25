package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.vistas.construibles.VistaDeConstruible;

public class ControladorEdificios extends MouseAdapter {

	private ControladorPartida controladorPartida;
	private VistaDeConstruible vistaEdificios;

	public ControladorEdificios(VistaDeConstruible vistaEdificios,
			ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
		this.vistaEdificios = vistaEdificios;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.controladorPartida.setEstado(vistaEdificios.getEstado());
	}

}
