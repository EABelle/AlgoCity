package algocity.core.procesadores;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Residencial;

public class Debitador implements Procesador {

	int total;
	private int precio;

	public Debitador(Mapa mapa) {
		total = 0;
		precio = 10;
	}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		total += precio * ((Residencial)(hectarea.getConstruible())).habitantes();
		
	}
	
	public int getPago() {
		int pago = total;
		total = 0;
		return pago;
	}

	@Override
	public void finalizarProceso() {
		// TODO Auto-generated method stub
		
	}


}
