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
	
	public void comenzarPartida() {
		Partida partida = new Partida(mapa);
		partida.inicializar();
		partida.jugar();
	}

}
