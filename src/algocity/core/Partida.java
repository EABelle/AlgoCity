package algocity.core;

import algocity.core.construibles.Construible;
import algocity.core.procesadores.CalculadorDeCalidadDeVida;
import algocity.core.procesadores.Debitador;
import algocity.core.procesadores.ProcesadorDeBomberos;

public class Partida {

	protected Mapa mapa;
	protected int turno;
	int plata;

	boolean inicializada;


	public Partida (Mapa mapa) {
		this.mapa = mapa;
		inicializada = false;
	}

	public void inicializar() {
		turno = 0;
		plata = Configuracion.PlataInicial;
		inicializada = true;
	}

	public boolean inicializada() {
		return inicializada;
	}
	public int getPlata(){
		return plata;
	}

	public boolean agregarConstruible(Construible construible, int x, int y) {
		if (plata >= construible.getCosto() &&
				mapa.agregarConstruible(construible, x, y)) {
			plata -= construible.getCosto();
			construible.procesarAgregado(mapa, x, y);
			return true;
		}
		return false;
	}


	public void pasarTurno() {
		turno ++;
		if ((turno % 30) == 0){
			Debitador debitador = new Debitador(mapa);
			plata += debitador.getPago();
		}

		ProcesadorDeBomberos procesadorBomberos = new ProcesadorDeBomberos(mapa);
		CalculadorDeCalidadDeVida calculador = new CalculadorDeCalidadDeVida(mapa);
	}

	public void jugar() {
		int turno = 0;
		while(turno < Configuracion.TurnoMaximo) {
			this.pasarTurno();
			turno++;
		}
	}

	public Mapa getMapa() {
		return mapa;
	}
}