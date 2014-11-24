package algocity.core.procesadores;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.CentralElectrica;

public class ProcesadorDeCentral extends ProcesadorDeAgregado {

	private CentralElectrica centralElectrica;

	public ProcesadorDeCentral(Mapa mapa, int x, int y) {
		super(mapa, x, y);
		mapa.getRedElectrica().agregarEdificioProveedor(x, y);
	}
	
	public void setCentral(CentralElectrica centralElectrica) {
		this.centralElectrica = centralElectrica;
		
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		hectarea.conectarRedElectrica();		
	}

	@Override
	public void finalizarProceso() {
		
	}

	@Override
	public Iterator<Hectarea> getIterator() {
		return mapa.recorrerEnUnRadio(centralElectrica.getRadioDeAlimentacion(), x, y);
	}

}
