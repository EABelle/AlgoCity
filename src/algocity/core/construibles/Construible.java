package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.core.procesadores.ProcesadorDeAgregado;

public abstract class Construible {

	protected int costo;
	private float porcentajeDeVida;


	public Construible() {
		porcentajeDeVida = 100;
	}

	public void daniar (float porcentajeDeDanio) {
		if ((porcentajeDeVida -=  porcentajeDeDanio) < 0) {
			porcentajeDeVida = 0;
		}
	}

	public void reparar (float porcentajeDeReparo) {
		if ((porcentajeDeVida +=  porcentajeDeReparo) > 100) {
			porcentajeDeVida = 100;
		}
	}

	public int getCosto() {
		return costo;
	}

	public boolean cumpleRequerimientos(boolean conexionAgua,
			boolean conexionRuta, boolean conexionElectrica){
		return true;
	}
	/*
	public void conectarARedDeAgua(){
		redDeAguaConectada = true;
	}

	public void conectarARedElectrica(){
		redElectricaConectada = true;
	}

	public void conectarARutaPavimentada(){
		rutaPavimentadaConectada = true;
	}

	public void desconectarDeRedDeAgua() {}
	public void desconectarDeRedElectrica() {}
	public void desconectarDeRutaPavimentada() {}

	public abstract void procesarAgregado(Partida partida, int x, int y);

	public void procesarTurno(Partida partida, int x, int y){
		//redefinido en los edificios y las centrales
	}

	public boolean daniado() {
		return porcentajeDeVida != 100;
	}
*/

	public ProcesadorDeAgregado getProcesador(Mapa mapa, int x, int y) {
		return new ProcesadorDeAgregado(mapa, x, y);
	}

}