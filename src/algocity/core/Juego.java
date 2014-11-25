package algocity.core;


public class Juego {

	Mapa mapa;

	public void prepararMapa(int filas, int columnas) {
		mapa = new Mapa(filas, columnas);
		mapa.llenar();
	}

	public Mapa getMapa() {
		return mapa;
	}

	public Partida crearPartida() {
		Partida partida = new Partida(mapa);
		partida.inicializar();
		return partida;
	}

}
