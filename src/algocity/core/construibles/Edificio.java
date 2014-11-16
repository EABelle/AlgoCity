package algocity.core.construibles;

import algocity.core.Partida;


public abstract class Edificio extends ConstruibleEnLlano {

	protected int consumo;
	
	public int getConsumo() {
		return consumo;
	}
	
	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		redDeAguaConectada = partida.redDeAguaConectada(x, y);
		redElectricaConectada = partida.redElectricaConectada(x, y);
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		
	}
}