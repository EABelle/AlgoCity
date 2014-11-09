package fiuba.algo3;

import fiuba.algo3.edificios.Edificio;

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
