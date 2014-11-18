package algocity.core;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.Coordenada;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.CentralElectrica;
import algocity.core.construibles.Construible;

public class Partida {

	protected Mapa mapa;
	protected RedDeAgua redDeAgua;
	protected RedElectrica redElectrica;
	protected RutaPavimentada rutaPavimentada;
	protected int turno;
	int plata;
	
	public class NodoEdificioDaniado{
		int x;
		int y;
		Construible construible;
		
		public NodoEdificioDaniado(int x, int y, Construible construible) {
			this.x = x;
			this.y = y;
			this.construible = construible;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public Construible getConstruible() {
			return construible;
		}
	}
	
	private ArrayList<NodoEdificioDaniado> edificiosDaniados;
	
	public Partida (Mapa mapa) {
		this.mapa = mapa;
		redDeAgua = new RedDeAgua();
		redElectrica = new RedElectrica();
		rutaPavimentada = new RutaPavimentada();
		turno = 0;
		plata = 20000;
	}
	
	public boolean agregarHectareaMapa (Hectarea hectarea){
		return mapa.cargarHectareaNueva(hectarea);
	}
	
	public int getPlata(){
		return plata;
	}
	
	public boolean agregarConstruible(Construible construible, int x, int y) {
		if (plata - construible.getCosto() >= 0){
			if (mapa.agregarConstruible(construible, x, y)){
				construible.procesarAgregado(this, x, y);
				plata -= construible.getCosto();
				return true;
			}
		}
		return false;
	}
	
	
	public boolean agregarConexionDeAgua (int x, int y) {
		
		if ((plata - redDeAgua.getCosto()) >= 0) {
			if (redDeAgua.agregarNodo(x, y)){
				return true;
			}
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


	public RedElectrica getRedElectrica() {
		return redElectrica;
	}

	public int getfilas() {
		return mapa.getfilas();
	}

	public int getcolumnas() {
		return mapa.getcolumnas();
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

	public void agregarDaniado(Construible construible, int x, int y) {
		edificiosDaniados.add(new NodoEdificioDaniado(x, y, construible));
	}
	
	/*public void pasarTurno() {
		edificiosDaniados = new ArrayList<Partida.NodoEdificioDaniado>();
		pasadorDeTurnos.pasarTurno(this, mapa, rutaPavimentada, edificiosDaniados);
		
	}*/

	private void pasoTurno() {
		if ((turno ++) == 30)
			turno = 0;
	}

	public void mandarBomberosDesdeHasta(int x, int y, Construible construible) {
		mapa.mandarBomberosDesdeHasta(x, y, construible);
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
	
	public void pasarTurno()/*(Partida partida, Mapa mapa, RutaPavimentada ruta,
			ArrayList<NodoEdificioDaniado> edificiosDaniados)*/ {
		edificiosDaniados = new ArrayList<Partida.NodoEdificioDaniado>();
		mapa.procesarTurno(this);
		rutaPavimentada.mandarBomberos(this, edificiosDaniados);
		pasoTurno();
		
	}

	public CentralElectrica buscarCentralDesde(int x, int y) {
		ArrayList<Coordenada> coordCentralesConectadas = redElectrica.buscarEdificiosProveedoresBFS(x, y);
		if (coordCentralesConectadas.isEmpty() ) {
			return null; //si no hay conexion a alguna central
		}
		Iterator<Coordenada> iter = coordCentralesConectadas.iterator();
		while (iter.hasNext()){
			Coordenada coordCentral = iter.next();
			if (coordCentral != null){
				int xCentral = coordCentral.getX();
				int yCentral = coordCentral.getY();
				CentralElectrica centralActual = mapa.getCentral(xCentral, yCentral);
				if (centralActual.cumpleRequerimientos())
					return centralActual;
			}
		}
		return null; //si ninguna central cumple los requerimientos
	}
	
}