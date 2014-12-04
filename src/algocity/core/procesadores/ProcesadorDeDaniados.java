package algocity.core.procesadores;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;

public class ProcesadorDeDaniados {
	
	public void procesarDanios(Mapa mapa, Hectarea hectarea) {
		Construible construible = hectarea.getConstruible(); 
		if ((construible != null) && (construible.daniado())) {
			mapa.getHectareasDaniadas().add(hectarea);
		}else if(mapa.getHectareasDaniadas().contains(hectarea)){
			mapa.getHectareasDaniadas().remove(hectarea);
		}
	}

}
