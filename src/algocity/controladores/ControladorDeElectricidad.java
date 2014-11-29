package algocity.controladores;

import algocity.core.capas.Hectarea;
import algocity.vistas.VistaDeHerramienta;

public class ControladorDeElectricidad extends Herramienta {

	public ControladorDeElectricidad(VistaDeHerramienta vistaHerramienta,
			ControladorPartida controladorPartida) {
		super(vistaHerramienta, controladorPartida);
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		if (controladorPartida.getPartida().agregarRedElectrica(
				hectarea.getFila(), hectarea.getColumna()))
			controladorPartida.setMensaje("Construidazo");
		else
			controladorPartida.setMensaje("No se puede construir aca");
	}

	@Override
	public String getEstado() {
		return "Construir electricidad";
	}


}
