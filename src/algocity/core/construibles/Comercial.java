package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.vistas.VistaDeInfo;

public class Comercial extends Edificio {

	public Comercial() {
		costo = 5;
		consumo = 2;

	}

	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getHectareasComerciales().add(mapa.getHectarea(x, y));
	}


	@Override
	public void teImpacta(Godzilla godzy) {
		godzy.impactame(this);
	}

	@Override
	public void mostrarInfo(VistaDeInfo vistaDeInfo) {
		vistaDeInfo.mostrarInfo(this);
	}
}