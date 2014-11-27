package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.vistas.tendido.VistaDeRuta;

public class ControladorDeRuta extends MouseAdapter {

	private VistaDeRuta vistaDeRuta;
	private ControladorPartida controladorPartida;

	public ControladorDeRuta(VistaDeRuta vistaDeRuta,
			ControladorPartida controladorPartida) {
		this.vistaDeRuta = vistaDeRuta;
		this.controladorPartida = controladorPartida;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

}
