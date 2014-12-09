package algocity.core.capas.tendido;

import algocity.core.capas.NodoTendido;

public class RutaPavimentada extends Tendido {

	public RutaPavimentada() {
		costo = 10;
	}

	@Override
	public boolean agregarNodo(NodoTendido nodo){
		return regenerarNodo(nodo);
	}

}