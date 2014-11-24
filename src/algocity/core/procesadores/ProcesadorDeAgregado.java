package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;

public class ProcesadorDeAgregado implements Procesador {

	int x;
	int y;
	Mapa mapa;

	public ProcesadorDeAgregado(Mapa mapa, int x, int y) {
		this.mapa = mapa;
		this.x = x;
		this.y = y;
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {

	}

	public Iterator<Hectarea> getIterator() {
		return new ArrayList<Hectarea>().iterator();
	}



}
