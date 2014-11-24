package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Residencial;

public class ProcesadorDeResidencial extends ProcesadorDeAgregado {

	Residencial residencial;

	public ProcesadorDeResidencial(Mapa mapa, int x, int y) {
		super(mapa, x, y);
	}

	public void setResidencial(Residencial res) {
		this.residencial = res;
	}


	public void finalizarProceso() {
		mapa.agregarResidencial(x, y);
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Hectarea> getIterator() {
		return new ArrayList<Hectarea>().iterator();
	}

}
