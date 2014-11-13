package algocity.core.capas;

import algocity.core.CalculadorDeCalidadDeVida;
import algocity.core.construibles.Construible;

public abstract class Hectarea 
implements CalculadorDeCalidadDeVida {
	
	Construible construible;
	int conexionesElectricas;
	
	public Hectarea() {
		construible = null;
		conexionesElectricas = 0;
	}
	
	public abstract boolean agregarConstruible(Construible construible);

	public boolean redElectricaConectada() {
		return (conexionesElectricas > 0);
	}
	
	public void conectarRedElectrica() {
		conexionesElectricas ++;
	}
	
	public void desconectarRedElectrica(){
		conexionesElectricas --;
	}
	
	public boolean borrarConstruible(){
		if (construible != null){
			construible = null;
			return true;
		}
		return false;
	}
}
