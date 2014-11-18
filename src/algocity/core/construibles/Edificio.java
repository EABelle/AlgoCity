package algocity.core.construibles;

import algocity.core.Partida;
import algocity.core.exceptions.ExcedidaLaCapacidadException;


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
	
	public void procesarTurno(Partida partida, int x, int y) {
		redDeAguaConectada = partida.redDeAguaConectada(x, y);
		redElectricaConectada = partida.redElectricaConectada(x, y);
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		if (daniado())
			partida.agregarDaniado(this, x, y);
		try {
			consumirElectricidad(partida, x, y);
		} catch (ExcedidaLaCapacidadException e) {
			redElectricaConectada = false;
		}
		
	}
	
	private void consumirElectricidad(Partida partida, int x, int y) throws ExcedidaLaCapacidadException{
		CentralElectrica central = partida.buscarCentralDesde(x,y);
		if (central == null)
			throw new ExcedidaLaCapacidadException();
		central.restarPotencia(consumo);
	}
}