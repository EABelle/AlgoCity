package algocity.controladores;

import algocity.core.capas.Hectarea;
import algocity.vistas.tendido.VistaDeRuta;

public class ControladorDeRuta extends Herramienta {

	public ControladorDeRuta(VistaDeRuta vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		if (controladorPartida.getPartida().agregarRutaPavimentada(
				hectarea.getFila(), hectarea.getColumna()))
			controladorPartida.setMensaje("Construidisimo");
		else
			controladorPartida.setMensaje("No se puede construir ruta aca");
	}

	@Override
	public String getEstado() {
		return "Construir ruta";
	}

	@Override
	public void procesarBorradoHectarea(Hectarea hectarea) {
		if (controladorPartida.getPartida().quitarRutaPavimentada(
				hectarea.getFila(), hectarea.getColumna()))
			controladorPartida.setMensaje("Borradisima");
		else
			controladorPartida.setMensaje("No se puede borrar ruta aca");
	}



}
