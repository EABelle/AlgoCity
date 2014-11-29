package algocity.vistas;

import java.awt.GridLayout;

import javax.swing.JPanel;

import algocity.controladores.ControladorDeCanieria;
import algocity.controladores.ControladorDeElectricidad;
import algocity.controladores.ControladorDeRuta;
import algocity.controladores.ControladorDeConstruible;
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
import algocity.vistas.tendido.VistaDeCanieria;
import algocity.vistas.tendido.VistaDeElectricidad;
import algocity.vistas.tendido.VistaDeRuta;

public class VistaDeHerramientas extends JPanel {

	ControladorPartida controladorPartida;

	public VistaDeHerramientas(ControladorPartida controladorPartida) {
		this.controladorPartida = controladorPartida;
		setLayout(new GridLayout(6, 2));

		agregarOpcion(new VistaDeResidencial());
		agregarOpcion(new VistaDeComercial());
		agregarOpcion(new VistaDeIndustrial());
		agregarOpcion(new VistaDeBomberos());
		agregarOpcion(new VistaDeCentralEolica());
		agregarOpcion(new VistaDeCentralMineral());
		agregarOpcion(new VistaDeCentralNuclear());
		agregarOpcion(new VistaDePozoDeAgua());

		agregarOpcion(new VistaDeRuta());
		agregarOpcion(new VistaDeCanieria());
		agregarOpcion(new VistaDeElectricidad());
	}

	private void agregarOpcion(VistaDeElectricidad vistaDeElectricidad) {
		vistaDeElectricidad.addMouseListener(
				new ControladorDeElectricidad(vistaDeElectricidad, controladorPartida));
		add(vistaDeElectricidad);
	}

	private void agregarOpcion(VistaDeCanieria vistaDeCanieria) {
		vistaDeCanieria.addMouseListener(
				new ControladorDeCanieria(vistaDeCanieria, controladorPartida));
		add(vistaDeCanieria);

	}

	private void agregarOpcion(VistaDeRuta vistaDeRuta) {
		vistaDeRuta.addMouseListener(
				new ControladorDeRuta(vistaDeRuta, controladorPartida));
		add(vistaDeRuta);

	}

	private void agregarOpcion(VistaDeConstruible vistaConstruible) {
		vistaConstruible.agregarControladorDeMouse(
				new ControladorDeConstruible(vistaConstruible, controladorPartida));
		add(vistaConstruible);
	}


}
