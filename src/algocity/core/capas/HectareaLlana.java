package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnLlano;

public class HectareaLlana extends Hectarea {

	@Override
	public boolean agregarConstruible(Construible construible) {
		try{
			if (agregarConstruibleEnLlano((ConstruibleEnLlano)construible)){
				return true;
			}
		}catch(Exception e){}
			//System.out.println("NO ES CONSTRUIBLE EN LLANO");
		return false;

	}
		


	private boolean agregarConstruibleEnLlano(ConstruibleEnLlano construible) {
		
		if (this.construible == null){
			this.construible = construible;
			return true;
		}
		return false;
	}

}