package algocity.core.capas;

import algocity.core.CalculadorDeCalidadDeVida;
import algocity.core.construibles.Construible;

public abstract class Hectarea 
implements CalculadorDeCalidadDeVida {
	
	Construible construible;
	boolean conexionesElectricas;
	
	public Hectarea() {
		construible = null;
		conexionesElectricas = false;
	}
	
	public abstract boolean agregarConstruible(Construible construible);

	public boolean redElectricaConectada() {
		return conexionesElectricas ;
	}
	
	public boolean redDeAguaConectada() {
		return false;
	}
	
	public void conectarRedElectrica() {
		conexionesElectricas = true;
	}
	
	public void desconectarRedElectrica(){
		conexionesElectricas = false;;
	}
	
	public boolean borrarConstruible(){
		if (construible != null){
			construible = null;
			return true;
		}
		return false;
	}

}
