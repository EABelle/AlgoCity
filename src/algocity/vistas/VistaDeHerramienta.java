package algocity.vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JToggleButton;

public class VistaDeHerramienta extends JToggleButton {

    protected String representacion;
	protected String estado;
	protected int x;
	protected int y;

	public VistaDeHerramienta() {
		x = 10;
		y = 10;
	}

	@Override
	public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);

        Dimension dimension = getSize();

        grafico.setColor(Color.white);
        grafico.fillRect(0, 0, dimension.width, dimension.height);

        grafico.setColor(Color.black);
        grafico.setFont(new Font("helvetica", Font.BOLD, 12));
        grafico.drawString(representacion, x, y);

    }

	public String getEstado() {
		return estado;
	}

	public String getRepresentacion() {
		return representacion;
	}
}
