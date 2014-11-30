package algocity.vistas;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import algocity.controladores.ControladorHectarea;
import algocity.controladores.ControladorPartida;
import algocity.core.Mapa;
import algocity.core.capas.Hectarea;

public class VistaDeMapa extends JPanel implements Observer {

	static int pasoX = 10;
	static int pasoY = 10;

	Mapa mapa;
	int filas;
	int columnas;
	private int startX;
	private int startY;
	private VistaDeHectarea[][] hectareas;

	public VistaDeMapa(Mapa mapa, ControladorPartida controladorPartida) {
		this.mapa = mapa;
		this.setLayout(new GridLayout(10, 10));
		inicializarMapa(controladorPartida);

	}

	private void inicializarMapa(ControladorPartida controladorPartida) {
		filas = mapa.getFilas();
		columnas = mapa.getColumnas();
		hectareas = new VistaDeHectarea[filas][columnas];
		startX = 0;
		startY = 0;

		for (int x = 0; x < filas; x++) {
			for (int y = 0; y < columnas; y++) {
				Hectarea hectarea = mapa.getHectarea(x, y);
				VistaDeHectarea vistaDeHectarea = new VistaDeHectarea(hectarea);
				vistaDeHectarea.addMouseListener(new ControladorHectarea(
						hectarea, vistaDeHectarea, controladorPartida));
				hectareas[x][y] = vistaDeHectarea;
			}
		}

		dibujarMapa();
	}

	private void dibujarMapa() {
		removeAll();

		int finX = startX + pasoX;
		int finY = startY + pasoY;
		for (int x = startX; x < finX; x++) {
			for (int y = startY; y < finY; y++) {
				add(hectareas[x][y]);
			}
		}

		revalidate();
		repaint();
	}

	public void moverMapa(int x, int y) {
		boolean hayCambio = false;
		if (filas >= (startX + pasoX + x) && (startX + x) >= 0) {
			startX += x;
			hayCambio = true;
		}
		if (columnas >= (startY + pasoY + y) && (startY + y) >= 0) {
			startY += y;
			hayCambio = true;
		}
		if (hayCambio) dibujarMapa();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}



}
