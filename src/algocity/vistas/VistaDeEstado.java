package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaDeEstado extends JPanel {

	JLabel estado;
	JLabel mensaje;

	public VistaDeEstado() {
		estado = new JLabel();
		mensaje = new JLabel();
		add(estado, BorderLayout.NORTH);
		add(mensaje, BorderLayout.SOUTH);
	}

	public void setEstado(String estado) {
		this.estado.setText(estado);
	}

	public void setMensaje(String text) {
		this.mensaje.setText(text);
	}

}
