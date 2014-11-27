package algocity.vistas.construibles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JToggleButton;

import algocity.controladores.ControladorEdificios;
import algocity.core.construibles.Construible;

public abstract class VistaDeConstruible extends JToggleButton {

    protected String representacion;
	protected String estado;

	@Override
	public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);

        Dimension dimension = getSize();

        grafico.setColor(Color.white);
        grafico.fillRect(0, 0, dimension.width, dimension.height);

        grafico.setColor(Color.black);
        grafico.setFont(new Font("helvetica", Font.BOLD, 12));
        grafico.drawString(representacion, 10, 10);

    }

	public abstract Construible getConstruible();

	public void agregarControladorDeMouse(ControladorEdificios controlador) {
		addMouseListener(controlador);
	}

	public String getEstado() {
		return estado;
	}

	public String getRepresentacion() {
		return representacion;
	}

}
