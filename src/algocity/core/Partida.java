package algocity.core;

import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.CentralElectrica;
import algocity.core.construibles.PozoDeAgua;

public class Partida {

	protected Mapa mapa;
	protected RedDeAgua redDeAgua;
	protected RedElectrica redElectrica;
	protected RutaPavimentada rutaPavimentada;

	public Partida (Mapa mapa) {
		this.mapa = mapa;
		redDeAgua = new RedDeAgua();
		redElectrica = new RedElectrica();
		rutaPavimentada = new RutaPavimentada();
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
			
			redElectrica.agregarEdificioProveedor(x, y);
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
		
		if  (mapa.agregarConstruible(pozo, x, y)) {
			redDeAgua.agregarEdificioProveedor(x, y);
			return true;
		}
		return false;
	}
	
	public boolean agregarConexionDeAgua (int x, int y) {
		
				if (redDeAgua.agregarNodo(x, y)){
					
					return true;
				}
				return false;
			
	}
	
	public boolean redDeAguaConectada(int x, int y) {
		
		return redDeAgua.servicioExiste(x, y);
	}
	
	
	public boolean agregarConexionElectrica(int x, int y) {
		if (redElectrica.agregarNodo(x, y)){
			mapa.getHectarea(x, y).conectarRedElectrica();
			return true;
		}
			return false;
	}

	public void desconectarRedElectrica(int x, int y) {
		
		redElectrica.eliminarNodo(x, y);
		
		
	}

	public boolean redElectricaConectada(int x, int y) {
		return (mapa.getHectarea(x, y).redElectricaConectada()) || (
				(!mapa.getHectarea(x, y).redElectricaConectada() && redElectrica.servicioExiste(x, y)));
	}

	

/*	public Hectarea getHectarea(int x, int y) {
 
		
		return mapa.getHectarea(x, y);
	}
*/
	
}
