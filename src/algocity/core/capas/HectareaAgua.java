package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnAgua;
import algocity.core.construibles.PozoDeAgua;

public class HectareaAgua extends Hectarea {

	PozoDeAgua pozoDeAgua;
	@Override
	public int calcularCalidadDeVida() {
		
		return 0;
	}

	@Override
	public boolean agregarConstruible(Construible construible) {
		try{
			return agregarConstruibleEnAgua ((ConstruibleEnAgua)construible);
		} catch (Exception e){
			//System.out.println("NO ES CONSTRUIBLE EN AGUA");
			return false;
		} 
	}

	private boolean agregarConstruibleEnAgua(ConstruibleEnAgua construible) {
		if (this.construible == null){
			this.construible = construible;
			return true;
		}
		return false;
		
	}

}
