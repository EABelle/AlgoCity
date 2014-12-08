package algocity.core;


public class Juego {

	Mapa mapa;
	private Jugador jugador;

	public void prepararMapa(int filas, int columnas) {
		mapa = new Mapa(filas, columnas);
		mapa.llenar();
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Partida crearPartida() {
		Partida partida = new Partida(mapa);
		partida.inicializar();
		return partida;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}
