package algocity.core;

import java.util.Random;

import algocity.core.capas.Hectarea;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.core.capas.catastrofes.Terremoto;
import algocity.core.construibles.Construible;
import algocity.core.procesadores.CalculadorDeCalidadDeVida;
import algocity.core.procesadores.Debitador;
import algocity.core.procesadores.ProcesadorDeBomberos;

public class Partida {

	protected Mapa mapa;
	protected int turno;
	int plata;
	Godzilla godzy;
	Terremoto terremoto;

	boolean inicializada;


	public Partida (Mapa mapa) {
		this.mapa = mapa;
		inicializada = false;
		godzy = null;
		terremoto = null;
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
	
	public boolean agreRutaPavimentada(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.rutaPavimentadaConectada())
			return false;
		hectarea.conectarRutaPavimentada();
		return true;
	}
	
	public boolean quitarRutaPavimentada(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.rutaPavimentadaConectada()){
			hectarea.desconectarRutaPavimentada();
			return true;
		}
		return false;
	}
	
	public boolean agreRedElectrica(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.redElectricaConectada())
			return false;
		hectarea.conectarRedElectrica();
		return true;
	}
	
	public boolean quitarRedElectrica(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.redElectricaConectada()){
			hectarea.desconectarRedElectrica();
			return true;
		}
		return false;
	}
	
	public boolean agreRedDeAgua(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.redDeAguaConectada())
			return false;
		hectarea.conectarRedDeAgua();
		return true;
	}
	
	public boolean quitarRedDeAgua(int x, int y) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (hectarea.redDeAguaConectada()){
			hectarea.desconectarRedDeAgua();
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

	/*public void jugando() {
		godzy = new Godzilla(Configuracion.RecorridoInicial);
		terremoto = new Terremoto(mapa);
		int turno = 0;
		while(turno < Configuracion.TurnoMaximo){
			if (generarCatastrofe()){
				
			}
			pasarTurno();
		}
	}*/
	
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
	
	private boolean generarGodzilla() {
		Random rn = new Random();
		return (rn.nextBoolean() & rn.nextBoolean() & rn.nextBoolean());
	}
}