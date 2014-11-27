package algocity.vistas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaDeEstado extends JPanel {

	private JLabel estado;
	private JLabel mensaje;
	private JLabel plata;


	public VistaDeEstado() {
		setLayout(new GridLayout(1, 3));
		estado = new JLabel();
		mensaje = new JLabel();
		mensaje.setForeground(Color.darkGray);
		plata = new JLabel();
		add(estado);
		add(mensaje);
		add(plata);
	}

	public void setEstado(String estado) {
		this.estado.setText(estado);
	}

	public void setMensaje(String text) {
		this.mensaje.setText(text);
	}

	public void setPlata(int plata) {
		this.plata.setText(String.format("Plata: %d", plata));
	}

}
