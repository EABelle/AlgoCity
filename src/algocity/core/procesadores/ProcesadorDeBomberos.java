package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Arreglable;
import algocity.core.construibles.Construible;
import algocity.core.construibles.EstacionDeBombero;

public class ProcesadorDeBomberos {
	private Mapa mapa;

	public ProcesadorDeBomberos(Mapa mapa) {
		this.mapa = mapa;
		procesar();
	}
	
	private void procesar(){
		Iterator<Hectarea> iterBombero;
		Iterator<Hectarea> iterDaniado;
		RutaPavimentada ruta = mapa.getRutaPavimentada();
		for(iterBombero = mapa.recorridoBomberos(); iterBombero.hasNext(); ) {
			Hectarea hectareaDeBombero = iterBombero.next();
			EstacionDeBombero bombero = (EstacionDeBombero)hectareaDeBombero.getConstruible();
			for(iterDaniado = mapa.recorridoDaniados(); iterDaniado.hasNext();) {
				Hectarea hectareaDaniada = iterDaniado.next();
				Arreglable daniado = (Arreglable) hectareaDaniada.getConstruible();
				if (ruta.existeConexionBFS(hectareaDeBombero.getFila(), 
					hectareaDeBombero.getColumna(),
					hectareaDaniada.getFila(),
					hectareaDaniada.getColumna())){
						bombero.reparar(daniado);
				}
			}
		}
	}

	
	/*	private EstacionDeBombero estacionDeBombero;
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
	}*/
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
