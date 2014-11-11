package algocity.core;

import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;

public class Mapa
implements CalculadorDeCalidadDeVida {
	Hectarea[][] hectareas;
	private int x;
	private int y;
	private int filas;
	private int columnas;
	private boolean cargadoCompleto;
	
	public Mapa(int dimension1, int dimension2){
		hectareas = new Hectarea[dimension1][dimension2];
		x = 0;
		y = 0;
		filas = dimension1;
		columnas = dimension2;
		cargadoCompleto = false;
	}

	public boolean cargarHectareaNueva(Hectarea hectarea) {
		
		if (x < filas) {
			if (y < columnas){
				hectareas[x][y] = hectarea;
				y ++;
			} else {
				x ++;
				y = 0;
				cargarHectareaNueva (hectarea);
			}
		}
		else cargadoCompleto = true;
		return cargadoCompleto;
	}
	
	public Hectarea getHectarea(int x, int y) {
		return hectareas[x][y];
	}
	
	public boolean agregarConstruible (Construible construible,
			int x, int y) {
		return hectareas[x][y].agregarConstruible(construible);
	}
	
	@Override
	public int calcularCalidadDeVida() {
		//en cada hectárea calcularCalidadDeVida();
		return 0;
	}

	public boolean cargado() {
		
		return cargadoCompleto;
	}

}
