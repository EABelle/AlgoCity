package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnAgua;
import algocity.core.construibles.PozoDeAgua;

public class HectareaAgua extends Hectarea {

	PozoDeAgua pozoDeAgua;
	@Override
	public int calcularCalidadDeVida() {
		
		return 0;
	}
	
	public boolean agregarConstruible(Construible construible){
		if (construible instanceof ConstruibleEnAgua) {
			this.construible = construible;
			return true;
		}
		return false;
	}
}
