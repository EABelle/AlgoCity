package algocity.core.capas.tendido;

public class RutaPavimentada extends Tendido {

	public RutaPavimentada() {
		costo = 10;
	}

	@Override
	public boolean agregarNodo(int coordenadaX, int coordenadaY){

		return regenerarNodo( coordenadaX,  coordenadaY);
	}

}