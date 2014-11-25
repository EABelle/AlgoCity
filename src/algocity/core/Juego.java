package algocity.core;

import algocity.controladores.ControladorPartida;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;

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
		VistaDePartida vistaDePartida = new VistaDePartida(partida);
		ControladorPartida controlador = new ControladorPartida(partida, vistaDePartida);
		VistaDeMapa vistaDeMapa = new VistaDeMapa(getMapa());
		vistaDePartida.add(vistaDeMapa);
		vistaDePartida.setVisible(true);
	}

}
