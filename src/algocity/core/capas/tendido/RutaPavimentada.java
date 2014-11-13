package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Iterator;

public class RutaPavimentada extends Tendido {

ArrayList<Coordenada> coordenadasCentralesElectricas;
	
	@Override
	public void agregarNodo(int coordenadaX, int coordenadaY)
			throws NodoExistenteException {
		
		if (this.getNodo(coordenadaX,coordenadaY) != null){
			throw new NodoExistenteException();
		}
		
		NodoTendido nodoNuevo = new NodoTendido(coordenadaX, coordenadaY);
		
		ArrayList<NodoTendido> vecinosPosibles = new ArrayList<NodoTendido>(); 
		vecinosPosibles.add(this.getNodo(coordenadaX+1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY+1));
		vecinosPosibles.add(this.getNodo(coordenadaX-1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY-1));
		
		Iterator<NodoTendido> iter = vecinosPosibles.iterator();
		
		while (iter.hasNext()){
			NodoTendido nodoActual = iter.next();
			if (nodoActual != null){
				hacerVecinos (nodoNuevo, nodoActual);
			}
		}
		
		this.nodos.add(nodoNuevo);
	}
	
	

}