package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.vistas.tendido.VistaDeElectricidad;

public class ControladorDeElectricidad extends MouseAdapter {

	private VistaDeElectricidad vistaDeElectricidad;
	private ControladorPartida controladorPartida;

	public ControladorDeElectricidad(VistaDeElectricidad vistaDeElectricidad,
			ControladorPartida controladorPartida) {
		this.vistaDeElectricidad = vistaDeElectricidad;
		this.controladorPartida = controladorPartida;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}


}
