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

	Mapa mapa;
	int filas;
	int columnas;

	public VistaDeMapa(Mapa mapa, ControladorPartida controladorPartida) {
		this.mapa = mapa;
		filas = mapa.getFilas();
		columnas = mapa.getColumnas();
		this.setLayout(new GridLayout(filas, columnas));
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Hectarea hectarea = mapa.getHectarea(i, j);
				VistaDeHectarea vistaDeHectarea = new VistaDeHectarea(hectarea);
				hectarea.dibujarse(vistaDeHectarea);
				vistaDeHectarea.addMouseListener(new ControladorHectarea(
						hectarea, vistaDeHectarea, controladorPartida));
				this.add(vistaDeHectarea);
			}
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}



}
