package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import algocity.core.capas.tendido.NodoTendido;

public class Tendido {

	ArrayList<NodoTendido> nodos;
		
	public Tendido () {
		this.nodos = new ArrayList<NodoTendido>();		
	}

	public void agregarNodo (int coordenadaX , int coordenadaY){
		NodoTendido nodoNuevo = new NodoTendido(coordenadaX, coordenadaY);
		
		NodoTendido vecino = this.getNodo(coordenadaX+1, coordenadaY);
		this.hacerVecinos (nodoNuevo, vecino);
		
		vecino = this.getNodo(coordenadaX, coordenadaY+1);
		this.hacerVecinos (nodoNuevo, vecino);
		
		vecino = this.getNodo(coordenadaX-1, coordenadaY);
		this.hacerVecinos (nodoNuevo, vecino);
		
		vecino = this.getNodo(coordenadaX, coordenadaY-1);
		this.hacerVecinos (nodoNuevo, vecino);
	}
	
	public void eliminarNodo (int coordenadaX , int coordenadaY){
		
		NodoTendido nodo = getNodo (coordenadaX , coordenadaY);
		quitarReferenciasDeVecinos(nodo);
		this.nodos.remove(nodo);
	}
	
	private NodoTendido getNodo (int coordenadaX , int coordenadaY){
		Iterator<NodoTendido> iter = nodos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();
			
			if ( (nodoActual.equals(coordenadaX)) && (nodoActual.equals(coordenadaY)) ){
				return nodoActual;				
			}
		}return null;
	}
	
	private void hacerVecinos (NodoTendido nodoNuevo, NodoTendido vecino){
		if ( vecino != null) {
			nodoNuevo.agregarVecino(vecino);
			vecino.agregarVecino(nodoNuevo);
		}	
	}
	
	private void quitarReferenciasDeVecinos(NodoTendido nodo){
	
		int coordenadaX = nodo.getCoordenadaX();
		int coordenadaY = nodo.getCoordenadaY();
		
		nodo.borrarVecino(coordenadaX+1, coordenadaY);
		nodo.borrarVecino(coordenadaX, coordenadaY+1);
		nodo.borrarVecino(coordenadaX-1, coordenadaY);
		nodo.borrarVecino(coordenadaX, coordenadaY-1);

	}
	
	public boolean nodoExisteBFS (NodoTendido nodoInicial, NodoTendido nodoFinal){
		
		ConcurrentLinkedQueue<NodoTendido> q = new ConcurrentLinkedQueue<NodoTendido>();
		Hashtable<NodoTendido, String> estadoVisitaNodo = new Hashtable<NodoTendido, String>();
		
		Iterator<NodoTendido> iter = nodos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();
			estadoVisitaNodo.put(nodoActual, "NO VISITADO");
		}
		
		estadoVisitaNodo.put(nodoInicial, "VISITADO");
		q.add(nodoInicial);
		
		while (!q.isEmpty()){
			NodoTendido nodoActual = q.poll();
			ArrayList<NodoTendido> vecinos = nodoActual.getVecinos();
			Iterator<NodoTendido> iterVecinos = vecinos.iterator();
			while ( iterVecinos.hasNext() ){
				NodoTendido vecino = iterVecinos.next();
				if (vecino.equals(nodoFinal))
					return true;
				if (estadoVisitaNodo.get(vecino) == "NO VISITADO"){
					estadoVisitaNodo.put(vecino, "VISITADO");
					q.add(vecino);
				}
			}
						
		}return false;
	}
}