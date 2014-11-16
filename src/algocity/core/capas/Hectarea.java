package algocity.core.capas;

import algocity.core.CalculadorDeCalidadDeVida;
import algocity.core.construibles.Construible;

public abstract class Hectarea 
implements CalculadorDeCalidadDeVida {
	
	Construible construible;
	boolean conexionElectrica;
	boolean conexionRuta;
	boolean conexionAgua;
	
	public Hectarea() {
		construible = null;
		conexionAgua = false;
		conexionElectrica = false;
		conexionRuta = false;
	}
	
	public abstract boolean agregarConstruible(Construible construible);

	public boolean redElectricaConectada() {
		return conexionElectrica ;
	}
	
	public boolean redDeAguaConectada() {
		return conexionAgua;
	}
	
	public boolean rutaPavimentadaConectada() {
		
		return conexionRuta;
	}

	
	public void conectarRedElectrica() {
		conexionElectrica = true;
	}
	
	public void desconectarRedElectrica(){
		conexionElectrica = false;;
	}
	
	public boolean borrarConstruible(){
		if (construible != null){
			construible = null;
			return true;
		}
		return false;
	}

	
}
