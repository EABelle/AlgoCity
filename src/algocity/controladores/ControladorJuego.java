package algocity.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import algocity.core.Juego;
import algocity.vistas.VentanaPrincipal;

public class ControladorJuego {

	Juego juego;
	VentanaPrincipal ventanaPrincipal;

	public ControladorJuego(Juego juego, VentanaPrincipal ventanaPrincipal) {
		this.juego = juego;
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void inicializar() {

		JButton botonComenzar = this.ventanaPrincipal.getBotonComenzar();
		botonComenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filas = ventanaPrincipal.getFilas();
				int columnas = ventanaPrincipal.getColumnas();
				juego.prepararMapa(filas, columnas);
				juego.comenzarPartida();
			}
		});

		ventanaPrincipal.setVisible(true);
	}

}
