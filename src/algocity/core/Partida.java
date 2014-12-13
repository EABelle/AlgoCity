package algocity.core;

import java.util.ArrayList;
import java.util.Observable;

import algocity.core.capas.Hectarea;
import algocity.core.capas.catastrofes.Catastrofe;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.core.capas.catastrofes.Terremoto;
import algocity.core.capas.tendido.Tendido;
import algocity.core.construibles.Construible;
import algocity.core.procesadores.CalculadorDeCalidadDeVida;
import algocity.core.procesadores.Debitador;
import algocity.core.procesadores.ProcesadorDeBomberos;
import algocity.core.procesadores.ProcesadorDeCatastrofes;
import algocity.core.procesadores.Refrescador;


public class Partida extends Observable {

	protected Mapa mapa;
	protected int turno;
	int plata;
	static int TIEMPO = 5; //en segundos
	boolean inicializada;
	boolean conCatastrofes;
	String estado;
	ArrayList<Catastrofe> catastrofes;

	public Partida (Mapa mapa) {
		this.mapa = mapa;
		inicializada = false;
		catastrofes = new ArrayList<Catastrofe>();
	}

	public void inicializar() {
		turno = 0;
		plata = Configuracion.PlataInicial;
		inicializada = true;
		conCatastrofes = true;
		Terremoto.inicializar();
		Godzilla.inicializar();
	}

	public boolean inicializada() {
		return inicializada;
	}

	public int getPlata(){
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public void setConCatastrofes(boolean conCatastrofes) {
		this.conCatastrofes = conCatastrofes;
	}

	public boolean agregarConstruible(Construible construible, int x, int y) {
		if (plata >= construible.getCosto() &&
				mapa.agregarConstruible(construible, x, y)) {
			construible.procesarAgregado(mapa, x, y);
			cobrar(construible.getCosto());
			return true;
		}
		return false;
	}

	public boolean quitarConstruible(int x, int y) {
		Construible construible = mapa.getHectarea(x, y).getConstruible();
		if (mapa.borrarConstruible(x, y)){
			construible.procesarBorrado(mapa, x, y);
			return true;
		}
		return false;
	}

	public boolean agregarRutaPavimentada(int x, int y) {
		return procesarConexion(x, y, mapa.getRutaPavimentada());
	}

	public boolean quitarRutaPavimentada(int x, int y) {
		return procesarDesconexion(x, y, mapa.getRutaPavimentada());
	}

	public boolean agregarRedElectrica(int x, int y) {
		return procesarConexion(x, y, mapa.getRedElectrica());
	}

	public boolean quitarRedElectrica(int x, int y) {
		return procesarDesconexion(x, y, mapa.getRedElectrica());
	}

	public boolean agregarRedDeAgua(int x, int y) {
		return procesarConexion(x, y, mapa.getRedDeAgua());
	}

	public boolean quitarRedDeAgua(int x, int y) {
		return procesarDesconexion(x, y, mapa.getRedDeAgua());
	}

	private boolean procesarConexion(int x, int y, Tendido tendido) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (tendido.getCosto() > plata) return false;
		if (!tendido.agregarNodo(hectarea)) return false;
		if (!tendido.setConexion(hectarea, true)) {
			tendido.eliminarNodo(hectarea);
			return false;
		}
		cobrar(tendido.getCosto());
		hectarea.procesarConexion(mapa);
		return true;
	}

	private boolean procesarDesconexion(int x, int y, Tendido tendido) {
		Hectarea hectarea = mapa.getHectarea(x, y);
		if (tendido.setConexion(hectarea, false)){
			tendido.eliminarNodo(hectarea);
			hectarea.procesarDesconexion(mapa);
			return true;
		}
		return false;
	}

	private void cobrar(int costo) {
		plata -= costo;
		hayCambios();
	}

	public void pasarTurno() {
		turno ++;
		setEstado("");
		if ((turno % 30) == 0){
			Debitador debitador = new Debitador(mapa);
			int pago = debitador.getPago();
			setEstado("Ganancia " + pago);
			plata += pago;
		}
		Refrescador.refresh(mapa);
		procesarCatastrofes();
		ProcesadorDeBomberos.procesar(mapa);
		CalculadorDeCalidadDeVida.procesar(mapa);
		ProcesadorDeCatastrofes.procesar(mapa, catastrofes);
		hayCambios();
	}

	private void procesarCatastrofes() {
		if (!this.conCatastrofes) return;
		Refrescador.actualizarCatastrofes(catastrofes);
		if (Godzilla.aparecer()) {
			catastrofes.add(new Godzilla(mapa.recorridoGodzilla(turno)));
			setEstado("Apareció Godzilla!");
		}
		if (Terremoto.aparecer()) {
			catastrofes.add(new Terremoto(mapa));
			setEstado("Apareció Terremoto!");
		}
	}

	public void jugar() {
		int turno = 0;
		while(turno < Configuracion.TurnoMaximo) {
			this.pasarTurno();
			turno++;
		}
	}

	public void setEstado(String estado) {
		if (this.estado != "" && estado != "") {
			this.estado += " | " + estado;
		} else {
			this.estado = estado;
		}
	}

	public String getEstado() {
		return estado;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public void hayCambios() {
		setChanged();
		notifyObservers();
	}
}