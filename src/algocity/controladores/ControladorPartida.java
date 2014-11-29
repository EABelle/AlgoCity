package algocity.controladores;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeEstado;
import algocity.vistas.VistaDeHerramientas;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;

public class ControladorPartida {

	Partida partida;
	VistaDePartida vistaDePartida;
	private VistaDeMapa vistaDeMapa;
	private VistaDeHerramientas vistaDeEdificios;
	private VistaDeEstado vistaDeEstado;
	private Herramienta herramienta;
	private ControladorHectarea controladorDeHectarea;

	public ControladorPartida(Partida partida, VistaDePartida vista) {
		this.partida = partida;
		this.vistaDePartida = vista;
	}

	public void inicializar() {
		vistaDeMapa = new VistaDeMapa(partida.getMapa(), this);
		vistaDePartida.agregarVistaDeMapa(vistaDeMapa);
		vistaDeEdificios = new VistaDeHerramientas(this);
		vistaDePartida.agregarVistaDeEdificios(vistaDeEdificios);
		vistaDeEstado = new VistaDeEstado();
		actualizarPlata();
		vistaDePartida.agregarVistaDeEstado(vistaDeEstado);
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
			ControladorDeConstruible controlador = (ControladorDeConstruible) herramienta;
			controladorDeHectarea.setRepresentacion(controlador.getRepresentacion());
			setMensaje("Construidisimo");
			actualizarPlata();
		}
		return resultado;
	}

	public void actualizarPlata() {
		vistaDeEstado.setPlata(partida.getPlata());
	}

	public void procesarClick(Hectarea hectarea) {
		if (this.herramienta != null)
			this.herramienta.procesarHectarea(hectarea);
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

}
