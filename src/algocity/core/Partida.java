package algocity.core;

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

	public Partida (Mapa mapa) {
		this.mapa = mapa;
		redDeAgua = new RedDeAgua();
		redElectrica = new RedElectrica();
		rutaPavimentada = new RutaPavimentada();
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
	
}
