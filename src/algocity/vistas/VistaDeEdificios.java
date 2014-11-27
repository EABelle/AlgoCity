package algocity.vistas;

import java.awt.GridLayout;

import javax.swing.JPanel;

import algocity.controladores.ControladorEdificios;
import algocity.controladores.ControladorPartida;
import algocity.vistas.construibles.VistaDeBomberos;
import algocity.vistas.construibles.VistaDeCentralEolica;
import algocity.vistas.construibles.VistaDeCentralMineral;
import algocity.vistas.construibles.VistaDeCentralNuclear;
import algocity.vistas.construibles.VistaDeComercial;
import algocity.vistas.construibles.VistaDeConstruible;
import algocity.vistas.construibles.VistaDeIndustrial;
import algocity.vistas.construibles.VistaDePozoDeAgua;
import algocity.vistas.construibles.VistaDeResidencial;

public class VistaDeEdificios extends JPanel {

	ControladorPartida controladorPartida;

	public VistaDeEdificios(ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
		setLayout(new GridLayout(4, 2));

		agregarOpcion(new VistaDeResidencial());
		agregarOpcion(new VistaDeComercial());
		agregarOpcion(new VistaDeIndustrial());
		agregarOpcion(new VistaDeBomberos());
		agregarOpcion(new VistaDeCentralEolica());
		agregarOpcion(new VistaDeCentralMineral());
		agregarOpcion(new VistaDeCentralNuclear());
		agregarOpcion(new VistaDePozoDeAgua());
	}

	private void agregarOpcion(VistaDeConstruible vistaConstruible) {
		vistaConstruible.agregarControladorDeMouse(
				new ControladorEdificios(vistaConstruible, controladorPartida));
		add(vistaConstruible);
	}

}
