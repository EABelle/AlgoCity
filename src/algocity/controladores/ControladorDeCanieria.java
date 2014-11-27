package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.vistas.tendido.VistaDeCanieria;

public class ControladorDeCanieria extends MouseAdapter {

	private VistaDeCanieria vistaDeElectricidad;
	private ControladorPartida controladorPartida;

	public ControladorDeCanieria(VistaDeCanieria vistaDeElectricidad,
			ControladorPartida controladorPartida) {
		this.vistaDeElectricidad = vistaDeElectricidad;
		this.controladorPartida = controladorPartida;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
