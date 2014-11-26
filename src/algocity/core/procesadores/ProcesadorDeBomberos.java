package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Construible;
import algocity.core.construibles.EstacionDeBombero;

public class ProcesadorDeBomberos extends ProcesadorDeAgregado {

	private EstacionDeBombero estacionDeBombero;
	private RutaPavimentada ruta;

	public ProcesadorDeBomberos(Mapa mapa, int x, int y) {
		super(mapa, x, y);
		mapa.getRutaPavimentada().agregarEdificioProveedor(x, y);
		}

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		Construible construible = hectarea.getConstruible();
		if (construible != null && construible.daniado()) {
		}
	}

	public void setRutaPavimentada(RutaPavimentada ruta) {
		this.ruta = ruta;
	}

	@Override
	public void finalizarProceso() {
		// TODO Auto-generated method stub
		
	}

	public void setBombero(EstacionDeBombero estacionDeBombero) {
		this.estacionDeBombero = estacionDeBombero;
		
	}
	
	@Override
	public Iterator<Hectarea> getIterator() {
		return mapa.getHectareasDaniadas().iterator();
	}
	
	
	public void setEstacionDeBomberos (EstacionDeBombero estacionDeBombero){
		this.estacionDeBombero = estacionDeBombero;
	}
//	private RutaPavimentada ruta;

	/*public class NodoEdificioDaniado{
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

	private ArrayList<NodoEdificioDaniado> edificiosDaniados;*/

	
/*	public RutaPavimentada getRutaPavimentada() {
		return ruta;
	}*/



}
