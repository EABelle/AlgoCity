package algocity.core.construibles;

import algocity.core.Mapa;


public class PozoDeAgua extends ConstruibleEnAgua {
	int costo;
	public PozoDeAgua(){
		costo = 250;
	}

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getRedDeAgua().agregarEdificioProveedor(x, y);
	}
}
