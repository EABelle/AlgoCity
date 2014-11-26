package algocity.core.construibles;

import algocity.core.Mapa;

public class EstacionDeBombero extends ConstruibleEnLlano {
		
	public void reparar (Arreglable arreglable) {
		arreglable.teArreglanLosBomberos(this);
	}
	
	void arreglar (Residencial residencial){
		residencial.reparar(10);
	}
	
	void arreglar (Comercial comercial){
		comercial.reparar(3);
	}

	void arreglar (Industrial industrial){
		industrial.reparar(10);
	}
	
	void arreglar (CentralEolica central){
		central.reparar(15);
	}
	
	void arreglar (CentralMineral central){
		central.reparar(10);
	}
	
	void arreglar (CentralNuclear central){
		central.reparar(3);
	}
	
	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		super.procesarAgregado(mapa, x, y);
		mapa.getHectareasDeBomberos().add(mapa.getHectarea(x, y));
	}
/*
	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		partida.agregarEstacionDeBomberos(x, y);
	}
*/
	
/*	@Override
	public void ProcesadorDeAgregado getProcesador(Mapa mapa, int x, int y) {
		ProcesadorDeBomberos procesador = new ProcesadorDeBomberos(mapa, x, y);
		procesador.setBombero(this);
		return procesador;
	}
	
*/
}
