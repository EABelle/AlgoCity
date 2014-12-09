package algocity.core.capas.tendido;

public class RutaPavimentada extends Tendido {

	public RutaPavimentada() {
		costo = 10;
	}

	@Override
	public boolean agregarNodo(NodoTendido nodo){
		return regenerarNodo(nodo);
	}

}