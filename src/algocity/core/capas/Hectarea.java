package algocity.core.capas;

import algocity.core.CalculadorDeCalidadDeVida;

public abstract class Hectarea 
implements CalculadorDeCalidadDeVida {
<<<<<<< Updated upstream
=======
	
	int conexionesElectricas;
	Construible construible;
	
	public Hectarea() {
		conexionesElectricas = 0;
	}
	
	public abstract boolean agregarConstruible(Construible construible);

	public boolean redElectricaConectada() {
		
		return (conexionesElectricas > 0);
	}
>>>>>>> Stashed changes
}
