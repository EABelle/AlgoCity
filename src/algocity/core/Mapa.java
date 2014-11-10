package algocity.core;

import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;

public class Mapa
implements CalculadorDeCalidadDeVida {
	Hectarea[][] hectareas;

	public Mapa(int dimensiones){
		hectareas= new Hectarea[dimensiones][dimensiones];
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
		
		return 0;
	}

}
