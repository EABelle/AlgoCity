package algocity.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import algocity.core.Juego;
import algocity.core.Jugador;
import algocity.core.Partida;
import algocity.core.io.GuardadorDePartida;
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
		inicializarBotonCargarPartida();
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
				crearPartida(filas, columnas);
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

	private void inicializarBotonCargarPartida() {
		ventanaPrincipal.getMenu().getBotonCargarPartida()
		.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Jugador jugador = juego.getJugador();
				if (jugador != null) {
					ArrayList<String> rutas = jugador.getPartidas();
					if (rutas.size() == 0) {
						ventanaPrincipal.setEstado("El jugador no tiene partidas guardadas");
						return;
					}
					Object[] options = rutas.toArray();
					String ruta = (String) JOptionPane.showInputDialog(null,
							"Seleccione partida", "Seleccionar partida",
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (ruta != null) {
						cargarPartida(ruta);
					}
				} else {
					ventanaPrincipal.setEstado("Seleccione el jugador");
				}
			}
		});
	}

	private void iniciarPartida(Partida partida) {
		VistaDePartida vistaDePartida = new VistaDePartida();
		vistaDePartida.setTitle("Juego de " + juego.getJugador().getNombre());
		controladorPartida = new ControladorPartida(
				partida, vistaDePartida, juego);
		controladorPartida.setManejadorDeJugadores(manejador);
		controladorPartida.inicializar();
		ventanaPrincipal.dispose();
	}

	private void crearPartida(int filas, int columnas) {
		juego.prepararMapa(filas, columnas);
		iniciarPartida(juego.crearPartida());
	}

	private void seleccionarJugador(Jugador jugador) {
		ventanaPrincipal.getMenu().setUsuario(jugador.getNombre());
		juego.setJugador(jugador);
	}

	private void cargarPartida(String ruta) {
		GuardadorDePartida cargador = new GuardadorDePartida();
		Partida partida = cargador.cargarPartida(ruta);
		juego.setMapa(partida.getMapa());
		iniciarPartida(partida);
	}
}
