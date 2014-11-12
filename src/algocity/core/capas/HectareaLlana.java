package algocity.core.capas;

import algocity.core.construibles.Construible;
import algocity.core.construibles.ConstruibleEnLlano;

public class HectareaLlana extends Hectarea {
		
	public HectareaLlana() {
		super();
	}
	@Override
	public int calcularCalidadDeVida() {
		return 0;
	}


	@Override
	public boolean agregarConstruible(Construible construible) {
		try{
			return agregarConstruibleEnLlano((ConstruibleEnLlano)construible);
		}catch(Exception e){
			/*se podria agregar sonido indicando que no es compatible*/
			return false;
		}
	}
		


	private boolean agregarConstruibleEnLlano(ConstruibleEnLlano construible) {
		
		if (this.construible == null){
			this.construible = construible;
			return true;
		}
		return false;
	}

}