package algocity.core.procesadores;

import algocity.core.Mapa;
import algocity.core.construibles.Residencial;

public class ProcesadorDeResidencial extends ProcesadorDeAgregado {

	Residencial residencial;

	public ProcesadorDeResidencial(Mapa mapa, int x, int y) {
		super(mapa, x, y);
	}

	public void setResidencial(Residencial res) {
		this.residencial = res;
	}



}
