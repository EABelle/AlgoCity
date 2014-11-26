package algocity.core.procesadores;

import algocity.core.Mapa;
import algocity.core.construibles.Industrial;

public class ProcesadorDeIndustrial extends ProcesadorDeAgregado {

	Industrial industrial;
	
	public ProcesadorDeIndustrial(Mapa mapa, int x, int y) {
		super(mapa, x, y);
	}
/*	
	@Override
	public void finalizarProceso() {
		mapa.getHectareasIndustriales().add(mapa.getHectarea(x, y));
	}
	*/
	public void setIndustrial(Industrial industrial) {
		this.industrial = industrial;
	}

	
}
