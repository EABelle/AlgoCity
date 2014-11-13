package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.PozoDeAgua;

public class HectareaAgua extends Hectarea {

	PozoDeAgua pozoDeAgua;
	@Override
	public int calcularCalidadDeVida() {
		
		return 0;
	}

	@Override
	public boolean agregarConstruible(Construible construible) {
		try{
			return agregarConstruibleEnAgua (construible);
		} catch (Exception e){
			/*agregar sonido de error*/
			return false;
		} 
	}

	private boolean agregarConstruibleEnAgua(Construible construible) {
		if (this.construible == null){
			this.construible = construible;
			return true;
		}
		return false;
		
	}

}
