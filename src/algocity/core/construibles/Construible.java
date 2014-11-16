package algocity.core.construibles;

import algocity.core.Partida;

public abstract class Construible {

	protected int costo;
	private int porcentajeDeVida;
	protected boolean redDeAguaConectada;
	protected boolean redElectricaConectada;
	protected boolean rutaPavimentadaConectada;
	
	public Construible() {
		porcentajeDeVida = 100;
		redDeAguaConectada = true;
		redElectricaConectada = true;
		rutaPavimentadaConectada = true;
	}
	
	public void daniar (int porcentajeDeDanio) {
		if ((porcentajeDeVida -=  porcentajeDeDanio) < 0) {
			porcentajeDeVida = 0;
		}
	}
	
	public void reparar (int porcentajeDeReparo) {
		if ((porcentajeDeVida +=  porcentajeDeReparo) > 100) {
			porcentajeDeVida = 100;
		}
	}
	
	public int getCosto() {
		return costo;
	}
	
	public boolean cumpleRequerimientos(){
		if (redDeAguaConectada && redElectricaConectada && rutaPavimentadaConectada){
			return true;
		}
		return false;
	}
	
	public void conectarARedDeAgua(){
		redDeAguaConectada = true;
	}
	
	public void conectarARedElectrica(){
		redElectricaConectada = true;
	}
	
	public void conectarARutaPavimentada(){
		rutaPavimentadaConectada = true;
	}
	
	public abstract void desconectarDeRedDeAgua();
	
	public abstract void desconectarDeRedElectrica();
	
	public abstract void desconectarDeRutaPavimentada();

	public abstract void procesarAgregado(Partida partida, int x, int y);
	
}