package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.core.procesadores.ProcesadorDeAgregado;
import algocity.core.procesadores.ProcesadorDeComercial;

public class Comercial extends Edificio {
	
	public Comercial() {
		costo = 5;
		consumo = 2;

	}
	
	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}

/*	@Override
	public ProcesadorDeAgregado getProcesador(Mapa mapa, int x, int y) {
		ProcesadorDeComercial procesador = new ProcesadorDeComercial(mapa, x, y);
		procesador.setComercial(this);
		return procesador;
	}*/
	
	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getHectareasComerciales().add(mapa.getHectarea(x, y));
	}
}