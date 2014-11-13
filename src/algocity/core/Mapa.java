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
	
	/*public boolean agregarConstruible (Edificio edificio,
			int x, int y) {
		return hectareas[x][y].agregarConstruible(edificio);
	}
	
	public boolean agregarConstruible (CentralElectrica central,
			int x, int y) {
		int i;
		int j;
		int radio;
		if (hectareas[x][y].agregarConstruible(central)){
			radio  = central.getRadioDeAlimentacion();
			for(i = 0; i <= 2 * radio; i++){
				for (j = 0; j <= 2 * radio; j++){
					if(((x - radio + i) >= 0 ) && ((x - radio + i) < filas) &&
							((y - radio + j) >= 0) && ((y - radio + j) <columnas))
					hectareas[x - radio + i][y - radio + j].conectarRedElectrica();
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean agregarConstruible (PozoDeAgua pozo,
			int x, int y) {
		redDeAgua.agregarPozo(x, y);
		return hectareas[x][y].agregarConstruible(pozo);
	}
	
	public boolean agregarConstruible ( RedDeAgua redDeAgua,
			int x, int y) {
		
				return redDeAgua.agregarNodo(x, y);
			
	}
	
	*/
	
	@Override
	public int calcularCalidadDeVida() {
		/*en cada hectárea calcularCalidadDeVida();*/
		return 0;
	}

	public boolean cargado() {
		
		return cargadoCompleto;
	}

	public int getfilas() {
		return filas;
	}

	public int getcolumnas() {
		return columnas;
	}

}
