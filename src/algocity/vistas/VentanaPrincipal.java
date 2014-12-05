package algocity.vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private MenuPanel menu;
	private JLabel estado;

	public VentanaPrincipal() {
		this.setTitle("AlgoCity v0.1");
		inicializarMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
	}

	private void inicializarMenu() {
		estado = new JLabel("Bienvenido al AlgoCity!");
		add(estado, BorderLayout.BEFORE_FIRST_LINE);
		menu = new MenuPanel();
		add(menu, BorderLayout.CENTER);
	}

	public MenuPanel getMenu() {
		return menu;
	}

	public void setEstado(String texto) {
		estado.setText(texto);
	}

}
