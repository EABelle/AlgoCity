package algocity.core.procesadores;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Residencial;

public class Debitador /*implements Procesador*/ {

	int total;
	private int precio;
	private Mapa mapa;

	public Debitador(Mapa mapa) {
		this.mapa = mapa;
		total = 0;
		precio = 10;
		procesar();
	}
	
	private void procesar() {
		Iterator<Hectarea> iter;
		for (iter = mapa.recorridoResidenciales(); iter.hasNext(); ){
			Hectarea hectarea = iter.next();
			procesarHectarea(hectarea);
		}
	}

//	@Override
	private void procesarHectarea(Hectarea hectarea) {
		total += precio * ((Residencial)(hectarea.getConstruible())).habitantes();
		
	}
	
	public int getPago() {
		int pago = total;
		total = 0;
		return pago;
	}

/*	@Override
	public void finalizarProceso() {
		// TODO Auto-generated method stub
		
	}*/

}
