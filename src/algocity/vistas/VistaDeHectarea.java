package algocity.vistas;

import java.awt.Color;

import javax.swing.JPanel;

import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;

public class VistaDeHectarea extends JPanel {

	public VistaDeHectarea() {
		this.setSize(10, 10);
	}

	public void dibujarHectarea(HectareaLlana hectarea) {
		this.setBackground(new Color(100, 200, 100));
	}

	public void dibujarHectarea(HectareaAgua hectarea) {
		this.setBackground(new Color(100, 100, 200));
	}

}
