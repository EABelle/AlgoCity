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

public class VistaDeHectarea extends JPanel implements Observer {

	private Hectarea hectarea;
	private String construible;

	public VistaDeHectarea(Hectarea hectarea) {
		this.setSize(10, 10);
		this.hectarea = hectarea;
		this.hectarea.addObserver(this);
		this.hectarea.dibujarse(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("helvetica", Font.BOLD, 12));
		if (this.construible != null) {
			g.setColor(Color.BLACK);
	        g.drawString(construible, 10, 10);
		}
		if (hectarea.redDeAguaConectada()) {
			g.setColor(Color.BLUE);
			g.drawString("a", 10, 30);
		}
		if (hectarea.redElectricaConectada()) {
			g.setColor(Color.YELLOW);
			g.drawString("e", 20, 30);
		}
		if (hectarea.rutaPavimentadaConectada()) {
			g.setColor(Color.GRAY);
			g.drawString("r", 30, 30);
		}

	}

	public void dibujarHectarea(HectareaLlana hectarea) {
		this.setBackground(new Color(100, 200, 100));
	}

	public void dibujarHectarea(HectareaAgua hectarea) {
		this.setBackground(new Color(100, 100, 200));
	}

	@Override
	public void update(Observable hectarea, Object arg) {
		((Hectarea) hectarea).dibujarse(this);
		this.repaint();
	}

	public void setConstruible(String representacion) {
		this.construible = representacion;
	}

}
