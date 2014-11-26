package algocity.core.construibles;

public abstract class Edificio extends ConstruibleEnLlano implements Arreglable {

	protected int consumo;
	
	public int getConsumo() {
		return consumo;
	}
	
	@Override
	public boolean cumpleRequerimientos(boolean conexionAgua, 
			boolean conexionRuta, boolean conexionElectrica){
		return conexionAgua & conexionRuta & conexionElectrica;
	}	
	
	/*
	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		redDeAguaConectada = partida.redDeAguaConectada(x, y);
		redElectricaConectada = partida.redElectricaConectada(x, y);
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		
	}
	
	public void procesarTurno(Partida partida, int x, int y) {
		redDeAguaConectada = partida.redDeAguaConectada(x, y);
		redElectricaConectada = partida.redElectricaConectada(x, y);
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		if (daniado())
			partida.agregarDaniado(this, x, y);
		
		if (!consumirElectricidad(partida, x, y) )
			redElectricaConectada = false;
		else
			redElectricaConectada = true;
		
	}
	
	private boolean consumirElectricidad(Partida partida, int x, int y){
		return partida.consumirElectricidadDesde(x,y,consumo);
	}	
	
*/
}