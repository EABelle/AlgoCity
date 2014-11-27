package algocity.core.procesadores;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;

public class ProcesadorDeDaniados {
	
	public void procesarDanios(Mapa mapa, Hectarea hectarea) {
		if (hectarea.getConstruible().daniado()){
			mapa.getHectareasDaniadas().add(hectarea);
		}else if(mapa.getHectareasDaniadas().contains(hectarea)){
			mapa.getHectareasDaniadas().remove(hectarea);
		}
	}

}
