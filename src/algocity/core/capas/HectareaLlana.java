package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.Edificio;

public class HectareaLlana extends Hectarea {

	protected Edificio edificio;

	public void agregarEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public int calcularCalidadDeVida() {
		return 0;
	}


	@Override
	public boolean agregarConstruible(Construible construible) {
		// TODO Auto-generated method stub
		return false;
	}

}
