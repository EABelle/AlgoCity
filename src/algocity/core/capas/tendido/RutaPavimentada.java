package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Iterator;

public class RutaPavimentada extends Tendido {

	public RutaPavimentada() {
		costo = 10;
	}

	@Override
	public boolean agregarNodo(int coordenadaX, int coordenadaY){

		return regenerarNodo( coordenadaX,  coordenadaY);
	}

}