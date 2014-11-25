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
		this.x = x;
		this.y = y;
		this.mapa = mapa;
	}

	public Iterator<Hectarea> getIterator() {
		return new ArrayList<Hectarea>().iterator();
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarProceso() {
		// TODO Auto-generated method stub
		
	}

}
