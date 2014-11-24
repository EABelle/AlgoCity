package algocity.core;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Construible;
import algocity.core.procesadores.CalculadorDeCalidadDeVida;
import algocity.core.procesadores.Debitador;
import algocity.core.procesadores.Procesador;
import algocity.core.procesadores.ProcesadorDeAgregado;
import algocity.core.procesadores.ProcesadorDeBomberos;
import algocity.core.procesadores.ProcesadorDeBomberos.NodoEdificioDaniado;

public class Partida {

	protected Mapa mapa;
/*	protected RedDeAgua redDeAgua;
	protected RedElectrica redElectrica;
	protected RutaPavimentada rutaPavimentada;*/
	protected int turno;
	int plata;

	boolean inicializada;

/*	public class NodoEdificioDaniado{
		int x;
		int y;
		Arreglable arreglable;

		public NodoEdificioDaniado(int x, int y, Arreglable arreglable) {
			this.x = x;
			this.y = y;
			this.arreglable = arreglable;
		}

		public int getX() {
			return x;
		}

		public int getY(){
			return y;
		}

		public Arreglable getConstruible() {
			return arreglable;
		}
	}
	*/
	private ArrayList<NodoEdificioDaniado> edificiosDaniados;

	public Partida (Mapa mapa) {
		this.mapa = mapa;
		inicializada = false;
	}

	public void inicializar() {
/*		redDeAgua = new RedDeAgua();
		redElectrica = new RedElectrica();
		rutaPavimentada = new RutaPavimentada();*/
		turno = 0;
		plata = Configuracion.PlataInicial;
		inicializada = true;
	}

	public boolean inicializada() {
		return inicializada;
	}
/*
	public boolean agregarHectareaMapa (Hectarea hectarea){
		return mapa.cargarHectareaNueva(hectarea);
	}
*/
	public int getPlata(){
		return plata;
	}

/*
	public boolean agregarConexionDeAgua (int x, int y) {

		if ((plata - redDeAgua.getCosto()) >= 0) {
			return redDeAgua.agregarNodo(x, y);
		}
		return false;

	}

	public boolean redDeAguaConectada(int x, int y) {
		return redDeAgua.servicioExiste(x, y);
	}


	public boolean agregarConexionElectrica(int x, int y) {
		if (plata - redElectrica.getCosto() >= 0) {
			if (redElectrica.agregarNodo(x, y)){
				this.conectarRedElectrica(x, y);
				return true;
			}
		}
		return false;
	}

	public void desconectarRedElectrica(int x, int y) {
		redElectrica.eliminarNodo(x, y);
	}

	public boolean redElectricaConectada(int x, int y) {
		return (mapa.cercanoACentralElecrica(x, y)) ||  redElectrica.servicioExiste(x, y);
	}

	public boolean rutaPavimentadaConectada(int x, int y) {

		return mapa.rutaPavimentadaConectada(x, y);
	}

	public int getfilas() {
		return mapa.getFilas();
	}

	public int getcolumnas() {
		return mapa.getColumnas();
	}

	public void conectarRedElectrica(int i, int j) {
		mapa.conectarHectareaARedElectrica(i, j);
	}

	public void agregarCentralElectrica(int x, int y) {
		redElectrica.agregarEdificioProveedor(x, y);
	}

	public void agregarPozoDeAgua(int x, int y) {
		redDeAgua.agregarEdificioProveedor(x, y);
	}

	public void agregarDaniado(Arreglable arreglable, int x, int y) {
		edificiosDaniados.add(new NodoEdificioDaniado(x, y, arreglable));
	}

*/
	public boolean agregarConstruible(Construible construible, int x, int y) {
		if (plata >= construible.getCosto()) {
			plata -= construible.getCosto();
			mapa.agregarConstruible(construible, x, y);
			ProcesadorDeAgregado procesador = construible.getProcesador(mapa, x, y);
			for (Iterator<Hectarea> iterator = procesador.getIterator(); iterator
					.hasNext();) {
				Hectarea hectarea = iterator.next();
				procesador.procesarHectarea(hectarea);
			}
			procesador.finalizarProceso();
			return true;
		}
		return false;
	}

/*	private ArrayList<Procesador> getProcesadores(int turno) {
		ArrayList<Procesador> procesadores = new ArrayList<Procesador>();
		CalculadorDeCalidadDeVida calculador = new CalculadorDeCalidadDeVida();
		ProcesadorDeBomberos bomberos = new ProcesadorDeBomberos();
		procesadores.add(calculador);
		procesadores.add(bomberos);
		if (turno % 30 == 0) {
			Debitador debitador = new Debitador();
			procesadores.add(debitador);
		}
		return procesadores;
	}

	public void pasarTurno() {
		turno++;
		ArrayList<Procesador> procesadores = getProcesadores(turno);
		for (Iterator<Hectarea> iteratorMapa = mapa.recorridoSecuencial();
				iteratorMapa.hasNext();) {
			Hectarea hectarea = iteratorMapa.next();
			for (Iterator<Procesador> iteratorProcesador = procesadores.iterator();
					iteratorProcesador.hasNext();) {
				Procesador procesador = iteratorProcesador.next();
				procesador.procesarHectarea(hectarea);
			}

		}

	}*/
	
	public void pasarTurno() {
		turno++;
		CalculadorDeCalidadDeVida calculador = new CalculadorDeCalidadDeVida();
		ProcesadorDeBomberos bomberos = new ProcesadorDeBomberos();
		if (turno % 30 == 0) {
			Debitador debitador = new Debitador(mapa);
			
			for(Iterator<Hectarea> iter = mapa.recorridoResidenciales(); 
					iter.hasNext();){
				debitador.procesarHectarea(iter.next());
			}
			plata += debitador.getPago();
		}
	}
/*
	public void mandarBomberosDesdeHasta(int x, int y, Arreglable arreglable) {
		mapa.mandarBomberosDesdeHasta(x, y, arreglable);
	}

	public boolean agregarRuta(int x, int y) {
		if (plata - rutaPavimentada.getCosto() >=0 ) {
			rutaPavimentada.agregarNodo(x, y);
			return true;
		}
		return false;
	}

	public void agregarEstacionDeBomberos(int x, int y) {
		rutaPavimentada.agregarEdificioProveedor(x, y);

	}

	public void pasarTurno() {
		edificiosDaniados = new ArrayList<Partida.NodoEdificioDaniado>();
		mapa.procesarTurno(this);
		rutaPavimentada.mandarBomberos(this, edificiosDaniados);
		pasoTurno();

	}

	public boolean consumirElectricidadDesde(int x, int y, int consumo) {
		ArrayList<Coordenada> coordCentralesConectadas = redElectrica.buscarEdificiosProveedoresBFS(x, y);
		CentralElectrica centralUtilizada = null; //si no hay conexion a alguna central

		if (!coordCentralesConectadas.isEmpty() ) {
			Iterator<Coordenada> iter = coordCentralesConectadas.iterator();
			while (iter.hasNext()){
				Coordenada coordCentral = iter.next();
				if (coordCentral != null){
					int xCentral = coordCentral.getX();
					int yCentral = coordCentral.getY();
					CentralElectrica centralActual = mapa.getCentral(xCentral, yCentral);
					if (centralActual.cumpleRequerimientos())
						centralUtilizada = centralActual;
				}
			}
		}
		if (centralUtilizada != null)
			return (centralUtilizada.restarPotencia(consumo));//si alguna central cumple los requerimientos

		return false;

	}
*/
	public void jugar() {
		int turno = 0;
		while(turno < Configuracion.TurnoMaximo) {
			this.pasarTurno();
			turno++;
		}
	}


}