package algocity.vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JToggleButton;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;

public class VistaDeHerramienta extends JToggleButton {

    protected String representacion;
	protected String estado;
	protected int costo;

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

	public String getInfo() {
		return "Costo $" + this.costo;
	}

	public void procesarPartida(Partida partida, Hectarea hectarea) {
	}
}
