package algocity.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import algocity.core.Juego;
import algocity.core.Partida;
import algocity.vistas.MenuPanel;
import algocity.vistas.VentanaPrincipal;
import algocity.vistas.VistaDePartida;

public class ControladorJuego {

	Juego juego;
	VentanaPrincipal ventanaPrincipal;
	MenuPanel menu;
	ControladorPartida controladorPartida;

	public ControladorJuego(Juego juego, VentanaPrincipal ventanaPrincipal) {
		this.juego = juego;
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void inicializar() {
		menu = new MenuPanel();
		JButton botonComenzar = menu.getBotonComenzar();
		botonComenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filas = menu.getFilas();
				int columnas = menu.getColumnas();
				juego.prepararMapa(filas, columnas);
				Partida partida = juego.crearPartida();
				VistaDePartida vistaDePartida = new VistaDePartida(partida);
				controladorPartida = new ControladorPartida(partida, vistaDePartida);
				controladorPartida.inicializar();
				ventanaPrincipal.dispose();
			}
		});

		ventanaPrincipal.add(menu);
		ventanaPrincipal.setVisible(true);
	}

}
