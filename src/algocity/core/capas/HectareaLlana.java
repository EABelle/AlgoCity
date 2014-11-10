package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnLlano;
import algocity.core.construibles.Edificio;

public class HectareaLlana extends Hectarea {

	@Override
	public int calcularCalidadDeVida() {
		return 0;
	}
	
	public boolean agregarConstruible(Construible construible) {
		if (construible instanceof ConstruibleEnLlano) {
			this.construible = construible;
			return true;
		}
		return false;
	}
}
