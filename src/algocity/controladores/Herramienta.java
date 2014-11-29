package algocity.controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algocity.core.capas.Hectarea;
import algocity.vistas.VistaDeHerramienta;

public abstract class Herramienta extends MouseAdapter {

	VistaDeHerramienta vistaHerramienta;
	ControladorPartida controladorPartida;

	public Herramienta(VistaDeHerramienta vistaHerramienta,
			ControladorPartida controladorPartida) {
		this.vistaHerramienta = vistaHerramienta;
		this.controladorPartida = controladorPartida;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		controladorPartida.setHerramienta(this);
	}

	public abstract void procesarHectarea(Hectarea hectarea);

}
