package algocity.core.procesadores;

import java.util.ArrayList;

import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.construibles.Construible;

public class ProcesadorDeBomberos implements Procesador {

	private RutaPavimentada ruta;

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

	@Override
	public void procesarHectarea(Hectarea hectarea) {
		Construible construible = hectarea.getConstruible();
		if (construible != null && construible.daniado()) {
		}
	}

	public void setRutaPavimentada(RutaPavimentada ruta) {
		this.ruta = ruta;
	}

/*	public RutaPavimentada getRutaPavimentada() {
		return ruta;
	}*/

	@Override
	public void finalizarProceso() {
		// TODO Auto-generated method stub
		
	}

}
