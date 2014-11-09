package algocity.core.capas;

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

}
