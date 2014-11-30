package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.vistas.VistaDeInfo;


public class PozoDeAgua extends ConstruibleEnAgua {

	public PozoDeAgua(){
		costo = 250;
	}

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getRedDeAgua().agregarEdificioProveedor(x, y);
	}

	@Override
	public void mostrarInfo(VistaDeInfo vistaDeInfo) {
		vistaDeInfo.mostrarInfo(this);
	}
}
