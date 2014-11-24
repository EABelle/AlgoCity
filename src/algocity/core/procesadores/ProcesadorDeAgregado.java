package algocity.core.procesadores;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;

public abstract class ProcesadorDeAgregado implements Procesador {
	int x;
	int y;
	Mapa mapa;

	public ProcesadorDeAgregado(Mapa mapa, int x, int y) {
		this.x = x;
		this.y = y;
		this.mapa = mapa;
	}

	public abstract Iterator<Hectarea> getIterator();

}
