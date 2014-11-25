package algocity.core.construibles;

public class EstacionDeBombero extends ConstruibleEnLlano {
		
	public void reparar (Arreglable arreglable) {
		arreglable.teArreglanLosBomberos(this);
	}
	
	public void arreglar (Residencial residencial){
		residencial.reparar(10);
	}
	
	public void arreglar (Comercial comercial){
		comercial.reparar(3);
	}

	public void arreglar (Industrial industrial){
		industrial.reparar(10);
	}
	
	public void arreglar (CentralEolica central){
		central.reparar(15);
	}
	
	public void arreglar (CentralMineral central){
		central.reparar(10);
	}
	
	public void arreglar (CentralNuclear central){
		central.reparar(3);
	}
/*
	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		partida.agregarEstacionDeBomberos(x, y);
	}
*/
}
