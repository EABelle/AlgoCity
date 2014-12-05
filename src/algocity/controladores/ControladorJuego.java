package algocity.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import algocity.core.Juego;
import algocity.core.Jugador;
import algocity.core.Partida;
import algocity.core.io.ManejadorDeJugadores;
import algocity.vistas.VentanaPrincipal;
import algocity.vistas.VistaDePartida;

public class ControladorJuego {

	Juego juego;
	VentanaPrincipal ventanaPrincipal;
	ControladorPartida controladorPartida;
	private ManejadorDeJugadores manejador;

	public ControladorJuego(Juego juego, VentanaPrincipal ventanaPrincipal) {
		this.juego = juego;
		this.ventanaPrincipal = ventanaPrincipal;
		this.manejador = new ManejadorDeJugadores();
		this.manejador.setRutaDeJugadores("files/jugadores");
	}

	public void inicializar() {
		inicializarMenu();
		ventanaPrincipal.setVisible(true);
	}

	private void inicializarMenu() {
		inicializarBotonComenzar();
		inicializarBotonSeleccionarUsuario();
		inicializarBotonAgregarUsuario();
	}

	private void inicializarBotonAgregarUsuario() {
		ventanaPrincipal.getMenu().getBotonComenzar()
			.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (juego.getJugador() == null) {
					ventanaPrincipal.setEstado("Seleccione un jugador!");
					return;
				}
				int filas = ventanaPrincipal.getMenu().getFilas();
				int columnas = ventanaPrincipal.getMenu().getColumnas();
				juego.prepararMapa(filas, columnas);
				Partida partida = juego.crearPartida();
				VistaDePartida vistaDePartida = new VistaDePartida(partida);
				vistaDePartida.setTitle("Juego de " + juego.getJugador().getNombre());
				controladorPartida = new ControladorPartida(
						partida, vistaDePartida, juego);
				controladorPartida.setManejadorDeJugadores(manejador);
				controladorPartida.inicializar();
				ventanaPrincipal.dispose();
			}
		});
	}

	private void inicializarBotonSeleccionarUsuario() {
		ventanaPrincipal.getMenu().getBotonUsuario()
			.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> optionList = manejador.nombresDeJugadores();
				Object[] options = optionList.toArray();
				String nombre = (String) JOptionPane.showInputDialog(null,
						"Seleccione jugador", "Seleccionar jugador",
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (nombre != null) {
					Jugador jugador = manejador.obtenerJugadorPorNombre(nombre);
					seleccionarJugador(jugador);
				}
			}

		});
	}

	private void inicializarBotonComenzar() {
		ventanaPrincipal.getMenu().getBotonAgregarUsuario()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Ingrese nombre del jugador");
				if (nombre != null) {
					Jugador jugador = manejador.crearJugador(nombre);
					if (jugador != null) seleccionarJugador(jugador);
					else ventanaPrincipal.setEstado("No se ha podido crear jugador!");
				}
			}
		});
	}

	private void seleccionarJugador(Jugador jugador) {
		ventanaPrincipal.getMenu().setUsuario(jugador.getNombre());
		juego.setJugador(jugador);
	}
}
