package algocity.controladores;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.vistas.VistaDeEstado;
import algocity.vistas.VistaDeHerramientas;
import algocity.vistas.VistaDeInfo;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;

public class ControladorPartida {

	Partida partida;
	VistaDePartida vistaDePartida;
	private VistaDeMapa vistaDeMapa;
	private VistaDeHerramientas vistaDeEdificios;
	private VistaDeEstado vistaDeEstado;
	private VistaDeInfo vistaDeInfo;
	private Herramienta herramienta;
	private ControladorHectarea controladorDeHectarea;

	public ControladorPartida(Partida partida, VistaDePartida vista) {
		this.partida = partida;
		this.vistaDePartida = vista;
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
		}
		return resultado;
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

	public void pasarTurno() {
		this.partida.pasarTurno();
	}

	public VistaDeInfo getVistaDeInfo() {
		return this.vistaDeInfo;
	}

}
