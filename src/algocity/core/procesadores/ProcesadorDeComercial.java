package algocity.core.procesadores;

import algocity.core.Mapa;
import algocity.core.construibles.Comercial;

public class ProcesadorDeComercial extends ProcesadorDeAgregado {

	Comercial comercial;
	public ProcesadorDeComercial(Mapa mapa, int x, int y) {
		super(mapa, x, y);
	}
	
	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}
	
	@Override
	public void finalizarProceso() {
		mapa.getHectareasComerciales().add(mapa.getHectarea(x, y));
	}

}
