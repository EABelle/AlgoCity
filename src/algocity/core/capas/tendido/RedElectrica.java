package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Iterator;

public class RedElectrica extends Tendido {

	ArrayList<Coordenada> coordenadasCentralesElectricas;
	
	public RedElectrica (){
		coordenadasCentralesElectricas = new ArrayList<Coordenada>();
	}
	
	@Override
	public boolean agregarNodo(int coordenadaX, int coordenadaY){
		
		if (this.getNodo(coordenadaX,coordenadaY) != null){
			return false;
		}
		
		NodoTendido nodoNuevo = new NodoTendido(coordenadaX, coordenadaY);
		
		ArrayList<NodoTendido> vecinosPosibles = new ArrayList<NodoTendido>(); 
		vecinosPosibles.add(this.getNodo(coordenadaX+1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY+1));
		vecinosPosibles.add(this.getNodo(coordenadaX-1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY-1));
		
		/*--------------------------------------------------------------------------------------------
		 * Agrega el nodo si son las coordenadas de una central
		 *------------------------------------------------------------------------------------------*/
		Iterator<Coordenada> iter2 = coordenadasCentralesElectricas.iterator();
		while (iter2.hasNext()){
			Coordenada coordenadaActual = iter2.next();
			if ( (coordenadaActual.getX() == coordenadaX) && (coordenadaActual.getY() == coordenadaY) ){
				this.nodos.add(nodoNuevo);
				return true;
			}
		}
		
		/*--------------------------------------------------------------------------------------------
		 * Agrega el nodo si hay algun nodo vecino
		 *------------------------------------------------------------------------------------------*/
		
		boolean hayVecinos = false;
		Iterator<NodoTendido> iter = vecinosPosibles.iterator();
		
		while (iter.hasNext()){
			NodoTendido nodoActual = iter.next();
			if (nodoActual != null){
				hayVecinos = true;
				hacerVecinos (nodoNuevo, nodoActual);
			}
		}
		
		if (hayVecinos){
			this.nodos.add(nodoNuevo);
			return true;
		}
		return false;

	}
	
	

}
