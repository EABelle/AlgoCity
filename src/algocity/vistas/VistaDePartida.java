package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import algocity.core.Partida;

public class VistaDePartida extends JFrame {

	public VistaDePartida(Partida partida) {
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
	}

	public void agregarVistaDeMapa(VistaDeMapa vistaMapa) {
		add(vistaMapa, BorderLayout.CENTER);
	}

	public void agregarVistaDeEdificios(VistaDeEdificios vistaEdificios) {
		add(vistaEdificios, BorderLayout.WEST);
	}

	public void agregarVistaDeEstado(VistaDeEstado vistaEstado) {
		add(vistaEstado, BorderLayout.NORTH);
	}

}
