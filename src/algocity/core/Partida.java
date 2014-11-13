package algocity.core;

import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.construibles.CentralElectrica;
import algocity.core.construibles.PozoDeAgua;

public class Partida {

	protected Mapa mapa;
	protected RedDeAgua redDeAgua;
	protected RedElectrica redElectrica;
	protected RutaPavimentada ruta;

	public Partida (Mapa mapa) {
		this.mapa = mapa;
		redDeAgua = new RedDeAgua();
	}
	
	public boolean agregarHectareaMapa (Hectarea hectarea){
		return mapa.cargarHectareaNueva(hectarea);
	}
	
	public boolean agregarConstruible (CentralElectrica central,
			int x, int y) {
		int i;
		int j;
		int radio;
		
		if (mapa.agregarConstruible(central, x, y)){
			radio  = central.getRadioDeAlimentacion();
				
			for(i = 0; i <= 2 * radio; i++) {
				for (j = 0; j <= 2 * radio; j++) {
					if(((x - radio + i) >= 0 ) && ((x - radio + i) < mapa.getfilas()) &&
							((y - radio + j) >= 0) && ((y - radio + j) <mapa.getcolumnas()))
						mapa.getHectarea(x - radio + i, y - radio + j).conectarRedElectrica();
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean agregarConstruible (PozoDeAgua pozo,
			int x, int y) {
		redDeAgua.agregarPozo(x, y);
		return mapa.getHectarea(x, y).agregarConstruible(pozo);
	}
	
	public boolean agregarConstruible ( RedDeAgua redDeAgua,
			int x, int y) {
		
				return redDeAgua.agregarNodo(x, y);
			
	}

}
