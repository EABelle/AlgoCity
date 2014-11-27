package algocity.controladores;

import algocity.core.Partida;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeEdificios;
import algocity.vistas.VistaDeEstado;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;
import algocity.vistas.construibles.VistaDeConstruible;

public class ControladorPartida {

	Partida partida;
	VistaDePartida vistaDePartida;
	private VistaDeMapa vistaDeMapa;
	private VistaDeEdificios vistaDeEdificios;
	private VistaDeEstado vistaDeEstado;
	private ControladorEdificios controladorEdificios;

	public ControladorPartida(Partida partida, VistaDePartida vista) {
		this.partida = partida;
		this.vistaDePartida = vista;
	}

	public void inicializar() {
		vistaDeMapa = new VistaDeMapa(partida.getMapa(), this);
		vistaDePartida.agregarVistaDeMapa(vistaDeMapa);
		vistaDeEdificios = new VistaDeEdificios(this);
		vistaDePartida.agregarVistaDeEdificios(vistaDeEdificios);
		vistaDeEstado = new VistaDeEstado();
		vistaDePartida.agregarVistaDeEstado(vistaDeEstado);
	}

	public void setEstado(String text) {
		vistaDeEstado.setEstado(text);
	}

	public void setMensaje(String text) {
		vistaDeEstado.setMensaje(text);
	}

	public void setControladorEdificios(
			ControladorEdificios controladorEdificios) {
		this.controladorEdificios = controladorEdificios;
	}

	public Construible getConstruible() {
		if (this.controladorEdificios != null) {
			return this.controladorEdificios.getConstruible();
		}
		return null;
	}

	public boolean agregarConstruible(Construible cons, int x, int y) {
		return this.partida.agregarConstruible(cons, x, y);
	}

	public VistaDeConstruible getVistaConstruible() {
		return this.controladorEdificios.getVistaConstruible();
	}

}
