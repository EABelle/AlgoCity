package algocity.controladores;

import algocity.core.Partida;
import algocity.vistas.VistaDeEdificios;
import algocity.vistas.VistaDeEstado;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;

public class ControladorPartida {

	Partida partida;
	VistaDePartida vistaDePartida;
	private VistaDeMapa vistaDeMapa;
	private VistaDeEdificios vistaDeEdificios;
	private VistaDeEstado vistaDeEstado;

	public ControladorPartida(Partida partida, VistaDePartida vista) {
		this.partida = partida;
		this.vistaDePartida = vista;
	}

	public void inicializar() {
		vistaDeMapa = new VistaDeMapa(partida.getMapa());
		vistaDePartida.agregarVistaDeMapa(vistaDeMapa);
		vistaDeEdificios = new VistaDeEdificios(this);
		vistaDePartida.agregarVistaDeEdificios(vistaDeEdificios);
		vistaDeEstado = new VistaDeEstado();
		vistaDePartida.agregarVistaDeEstado(vistaDeEstado);
	}

	public void setEstado(String text) {
		vistaDeEstado.setEstado(text);
	}

}
