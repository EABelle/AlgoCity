package algocity.core;

import java.util.ArrayList;

import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Construible;

public class Partida {

	protected Mapa mapa;
	protected RedDeAgua redDeAgua;
	protected RedElectrica redElectrica;
	protected RutaPavimentada rutaPavimentada;
	protected PasadorDeTurnos pasadorDeTurnos;
	protected int turno;
	
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
		pasadorDeTurnos = new PasadorDeTurnos();
		turno = 0;
	}
	
	public boolean agregarHectareaMapa (Hectarea hectarea){
		return mapa.cargarHectareaNueva(hectarea);
	}
	
	
	public boolean agregarConstruible(Construible construible, int x, int y) {
		if (mapa.agregarConstruible(construible, x, y)){
			construible.procesarAgregado(this, x, y);
			return true;
		}
		return false;
	}
	
	
	public boolean agregarConexionDeAgua (int x, int y) {
		
		if (redDeAgua.agregarNodo(x, y)){
			return true;
		}
		return false;
			
	}
	
	public boolean redDeAguaConectada(int x, int y) {
		return redDeAgua.servicioExiste(x, y);
	}
	
	
	public boolean agregarConexionElectrica(int x, int y) {
		if (redElectrica.agregarNodo(x, y)){
			this.conectarRedElectrica(x, y);
			return true;
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
	
	public void pasarTurno() {
		edificiosDaniados = new ArrayList<Partida.NodoEdificioDaniado>();
		pasadorDeTurnos.pasarTurno(this, mapa, rutaPavimentada, edificiosDaniados);
		
	}

	public void pasoTurno() {
		turno ++;
		
	}

	public void mandarBomberosDesdeHasta(int x, int y, Construible construible) {
		mapa.mandarBomberosDesdeHasta(x, y, construible);
	}

	public void agregarRuta(int x, int y) {
		rutaPavimentada.agregarNodo(x, y);
	}

	public void agregarEstacionDeBomberos(int x, int y) {
		rutaPavimentada.agregarEdificioProveedor(x, y);
		
	}
	
}