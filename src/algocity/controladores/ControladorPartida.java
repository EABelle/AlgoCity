package algocity.controladores;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import algocity.core.Juego;
import algocity.core.Jugador;
import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.core.io.GuardadorDePartida;
import algocity.core.io.ManejadorDeJugadores;
import algocity.threads.ProcesoMusicaPartida;
import algocity.threads.ProcesoTimerTurno;
import algocity.vistas.VistaDeEstado;
import algocity.vistas.VistaDeHerramientas;
import algocity.vistas.VistaDeInfo;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;

public class ControladorPartida {

	Partida partida;
	VistaDePartida vistaDePartida;
	private Juego juego;
	private VistaDeMapa vistaDeMapa;
	private VistaDeHerramientas vistaDeEdificios;
	private VistaDeEstado vistaDeEstado;
	private VistaDeInfo vistaDeInfo;
	private Herramienta herramienta;
	private ControladorHectarea controladorDeHectarea;
	private ControladorDeMapa controladorDeMapa;
	private ProcesoMusicaPartida musica;
	private ProcesoTimerTurno timerTurno;
	private ManejadorDeJugadores manejadorDeJugadores;

	public ControladorPartida(Partida partida, VistaDePartida vista, Juego juego) {
		this.partida = partida;
		this.vistaDePartida = vista;
		this.juego = juego;
	}

	public void inicializar() {

		vistaDeMapa = new VistaDeMapa(partida.getMapa(), this);
		vistaDeEdificios = new VistaDeHerramientas(this);
		vistaDeEstado = new VistaDeEstado(this);
		vistaDeInfo = new VistaDeInfo();

		vistaDePartida.agregarVistaDeMapa(vistaDeMapa);
		vistaDePartida.agregarVistaDeEdificios(vistaDeEdificios);
		vistaDePartida.agregarVistaDeEstado(vistaDeEstado);
		vistaDePartida.agregarVistaDeInfo(vistaDeInfo);

		partida.addObserver(vistaDeEstado);
		partida.hayCambios();
		inicializarTeclado();
		inicializarMusica();
		inicializarTimer();

	}

	private void inicializarTimer() {
		timerTurno = new ProcesoTimerTurno(partida);
		timerTurno.start();
	}

	public int getTiempoRestante() {
		if (timerTurno != null)
			return timerTurno.getTiempoRestante();
		return 0;
	}

	private void inicializarMusica() {
		musica = new ProcesoMusicaPartida();
		musica.start();
	}

	public void playPauseMusic() {
		musica.playPauseMusic();

	}


	private void inicializarTeclado() {
		controladorDeMapa = new ControladorDeMapa(vistaDeMapa);

		// Esto es necesario para capturar eventos de teclado en todos los paneles
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		    	if (e.getID() == KeyEvent.KEY_PRESSED) {
		    		controladorDeMapa.keyPressed(e);
		    	}
		        return false;
		      }
		});


	}

	public void setEstado(String text) {
		vistaDeEstado.setEstado(text);
	}

	public void setMensaje(String text) {
		vistaDeEstado.setMensaje(text);
	}

	public boolean agregarConstruible(Construible cons, int x, int y) {
		boolean resultado = this.partida.agregarConstruible(cons, x, y);
		if (!resultado) {
			setMensaje("No se puede construir aca");
		} else {
			setMensaje("Construidisimo");
		}
		return resultado;
	}

	public void procesarClick(Hectarea hectarea) {
		if (this.herramienta != null)
			this.herramienta.procesarHectarea(hectarea);
	}

	public void procesarClickDerecho(Hectarea hectarea) {
		if (this.herramienta != null)
			this.herramienta.procesarBorradoHectarea(hectarea);
	}

	public void setHerramienta(Herramienta herramienta) {
		setEstado(herramienta.getEstado());
		this.herramienta = herramienta;
	}

	public void setControladorDeHectarea(ControladorHectarea controladorHectarea) {
		this.controladorDeHectarea = controladorHectarea;
	}

	public Partida getPartida() {
		return partida;
	}

	public void pasarTurno() {
		this.partida.pasarTurno();
		this.timerTurno.reset();
	}

	public VistaDeInfo getVistaDeInfo() {
		return this.vistaDeInfo;
	}

	public void guardarPartida(String ruta) {
		GuardadorDePartida guardador = new GuardadorDePartida();
		if (guardador.guardarPartida(partida, ruta)) {
			Jugador jugador = juego.getJugador();
			jugador.agregarPartida(ruta);
			manejadorDeJugadores.actualizarJugador(jugador);
			setEstado("Guardadisima la partida!");
		} else {
			setEstado("No se ha podido guardar la partida!");
		}
	}

	public Juego getJuego() {
		return juego;
	}

	public void setManejadorDeJugadores(ManejadorDeJugadores manejador) {
		this.manejadorDeJugadores = manejador;
	}

	public void playPauseTimer() {
		timerTurno.playPause();
	}

	public boolean timerEstaCorriendo(){
		return timerTurno.estaCorriendo();
	}

	public boolean musicaEstaCorriendo(){
		return musica.estaCorriendo();
	}


}
