package algocity.core.capas;

import algocity.core.CalculadorDeCalidadDeVida;
import algocity.core.construibles.Construible;

public abstract class Hectarea 
implements CalculadorDeCalidadDeVida {
	
	int ConexionesElectricas;
	Construible construible;
	
	public Hectarea() {
		ConexionesElectricas = 0;
	}
	
	public abstract boolean agregarConstruible(Construible construible);
}
