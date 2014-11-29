package algocity.core.construibles;

import algocity.vistas.VistaDeInfo;


public class PozoDeAgua extends ConstruibleEnAgua {

	public PozoDeAgua(){
		costo = 250;
	}

	@Override
	public void mostrarInfo(VistaDeInfo vistaDeInfo) {
		vistaDeInfo.mostrarInfo(this);
	}

}
