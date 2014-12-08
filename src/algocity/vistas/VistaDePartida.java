package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VistaDePartida extends JFrame {

	public VistaDePartida() {
		setSize(1000, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
	}

	public void agregarVistaDeMapa(VistaDeMapa vistaMapa) {
		add(vistaMapa, BorderLayout.CENTER);
	}

	public void agregarVistaDeEdificios(VistaDeHerramientas vistaEdificios) {
		add(vistaEdificios, BorderLayout.WEST);
	}

	public void agregarVistaDeEstado(VistaDeEstado vistaEstado) {
		add(vistaEstado, BorderLayout.NORTH);
	}

	public void agregarVistaDeInfo(VistaDeInfo vistaDeInfo) {
		add(vistaDeInfo, BorderLayout.SOUTH);
	}

}
