package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.core.construibles.Construible;
import algocity.vistas.construibles.VistaDeConstruible;

public class ControladorEdificios extends MouseAdapter {

	private ControladorPartida controladorPartida;
	private VistaDeConstruible vistaConstruible;

	public ControladorEdificios(VistaDeConstruible vistaEdificios,
			ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
		this.vistaConstruible = vistaEdificios;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.controladorPartida.setEstado(vistaConstruible.getEstado());
		this.controladorPartida.setControladorEdificios(this);
	}

	public Construible getConstruible() {
		return vistaConstruible.getConstruible();
	}

	public VistaDeConstruible getVistaConstruible() {
		return vistaConstruible;
	}

}
