package algocity.core.capas;

import algocity.core.CalculadorDeCalidadDeVida;
import algocity.core.construibles.Construible;

public abstract class Hectarea 
implements CalculadorDeCalidadDeVida {
	
	int conexionesElectricas;
	Construible construible;
	
	public Hectarea() {
		conexionesElectricas = 0;
	}
	
	public abstract boolean agregarConstruible(Construible construible);

	public boolean redElectricaConectada() {
		
		return (conexionesElectricas > 0);
	}
}
