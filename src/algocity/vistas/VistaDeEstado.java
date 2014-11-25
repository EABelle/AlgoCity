package algocity.vistas;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaDeEstado extends JPanel {

	JLabel estado;

	public VistaDeEstado() {
		estado = new JLabel();
		add(estado);
	}

	public void setEstado(String estado) {
		this.estado.setText(estado);
	}

}
