package algocity.vistas;

import java.awt.GridLayout;

import javax.swing.JPanel;

import algocity.controladores.ControladorEdificios;
import algocity.controladores.ControladorPartida;
import algocity.vistas.construibles.VistaDeComercial;
import algocity.vistas.construibles.VistaDeIndustrial;
import algocity.vistas.construibles.VistaDeResidencial;

public class VistaDeEdificios extends JPanel {

	public VistaDeEdificios(ControladorPartida controladorPartida) {
		setLayout(new GridLayout(2, 2));
		VistaDeResidencial vistaResidencial = new VistaDeResidencial();
		VistaDeComercial vistaComercial = new VistaDeComercial();
		VistaDeIndustrial vistaIndustrial = new VistaDeIndustrial();

		vistaResidencial.agregarControladorDeMouse(
				new ControladorEdificios(vistaResidencial, controladorPartida));
		vistaComercial.agregarControladorDeMouse(
				new ControladorEdificios(vistaComercial, controladorPartida));
		vistaIndustrial.agregarControladorDeMouse(
			new ControladorEdificios(vistaIndustrial, controladorPartida));

		add(vistaResidencial);
		add(vistaComercial);
		add(vistaIndustrial);
	}

}
