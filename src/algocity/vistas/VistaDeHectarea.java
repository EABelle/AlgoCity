package algocity.vistas;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

import algocity.core.capas.Hectarea;

public class VistaDeHectarea extends JButton {

	public VistaDeHectarea(Hectarea hectarea) {
		this.setSize(10, 10);
		Random r = new Random();
		this.setBackground(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
	}

}
