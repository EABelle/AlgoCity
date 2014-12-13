package algocity.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.Construible;

public class VistaDeHectarea extends JPanel implements Observer {

	private Hectarea hectarea;
	private String construible;
	private Graphics actualGraphics;

	public VistaDeHectarea(Hectarea hectarea) {
		this.setSize(10, 10);
		this.hectarea = hectarea;
		this.hectarea.addObserver(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		actualGraphics = g;

		g.setFont(new Font("helvetica", Font.BOLD, 16));

		printConstruible();
		g.setFont(new Font("helvetica", Font.PLAIN, 12));
		if (hectarea.redDeAguaConectada()) {
			actualGraphics.setColor(Color.BLUE);
			actualGraphics.drawString("a", 10, 30);
		}
		hectarea.dibujarse(this);

	}

	private void printConstruible() {
		Construible cons = hectarea.getConstruible();
		if (cons != null) {
			int r = 30; int g = 30; int b = 30;
			r += (100 - cons.getPorcetajeDeVida()) * 2;
			Color color = new Color(r, g, b);
			actualGraphics.setColor(color);
			actualGraphics.drawString(cons.getRepresentation(), 10, 15);
		}
	}

	public void dibujarHectarea(HectareaLlana hectarea) {
		this.setBackground(new Color(100, 200, 100));
		if (hectarea.redElectricaConectada()) {
			actualGraphics.setColor(Color.YELLOW);
			actualGraphics.drawString("e", 20, 30);
		}
		if (hectarea.hayTendidoElectrico()) {
			actualGraphics.setColor(Color.ORANGE);
			actualGraphics.drawString("t", 0, 30);
		}
		if (hectarea.rutaPavimentadaConectada()) {
			actualGraphics.setColor(Color.GRAY);
			actualGraphics.drawString("r", 30, 30);
		}
		if (hectarea.hayGodzilla()) {
			actualGraphics.setColor(Color.RED);
			actualGraphics.drawString("G", 20, 20);
		}
		if (hectarea.hayTerremoto()) {
			actualGraphics.setColor(Color.RED);
			actualGraphics.drawString("T", 30, 20);
		}
	}

	public void dibujarHectarea(HectareaAgua hectarea) {
		this.setBackground(new Color(100, 100, 200));
	}

	@Override
	public void update(Observable hectarea, Object arg) {
		this.repaint();
	}

}
