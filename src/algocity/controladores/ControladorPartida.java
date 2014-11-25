package algocity.controladores;

import algocity.core.Partida;
import algocity.vistas.VistaDePartida;

public class ControladorPartida {

	Partida partida;
	VistaDePartida vista;

	public ControladorPartida(Partida partida, VistaDePartida vista) {
		this.partida = partida;
		this.vista = vista;
	}

}
