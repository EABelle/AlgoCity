package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Iterator;

public class RutaPavimentada extends Tendido {

ArrayList<Coordenada> coordenadasCentralesElectricas;
	
	@Override
	public boolean agregarNodo(int coordenadaX, int coordenadaY){
		
		if ( this.nodoExiste(coordenadaX,coordenadaY) )
			return false;
		
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
		return true;
	}
	
	

}