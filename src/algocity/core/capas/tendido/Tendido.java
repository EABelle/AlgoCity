package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

import algocity.core.capas.Hectarea;
import algocity.core.capas.NodoTendido;

abstract public class Tendido {

	ArrayList<NodoTendido> nodos;
	ArrayList<Coordenada> edificiosProveedores;
	int costo;

	public Tendido () {
		this.nodos = new ArrayList<NodoTendido>();
		this.edificiosProveedores = new ArrayList<Coordenada>();
		costo = 5;
	}

	public int getCosto() {
		return costo;
	}

	public ArrayList<NodoTendido> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<NodoTendido> nodos) {
		this.nodos = nodos;
	}

	public ArrayList<Coordenada> getEdificiosProveedores() {
		return edificiosProveedores;
	}

	public void setEdificiosProveedores(
			ArrayList<Coordenada> edificiosProveedores) {
		this.edificiosProveedores = edificiosProveedores;
	}

	public boolean agregarNodo (NodoTendido nodo) {
		int coordenadaX = nodo.getX();
		int coordenadaY = nodo.getY();
		if ( this.nodoExiste(coordenadaX, coordenadaY) )
			return false;

		/*--------------------------------------------------------------------------------------------
		 * Agrega el nodo si son las coordenadas de una central
		 *------------------------------------------------------------------------------------------*/
		Iterator<Coordenada> iter2 = edificiosProveedores.iterator();
		while (iter2.hasNext()){
			Coordenada coordenadaActual = iter2.next();
			if ( (coordenadaActual.getX() == coordenadaX) && (coordenadaActual.getY() == coordenadaY) ){
				this.nodos.add(nodo);
				return true;
			}
		}

		/*--------------------------------------------------------------------------------------------
		 * Agrega el nodo si hay algun nodo vecino
		 *------------------------------------------------------------------------------------------*/

		ArrayList<NodoTendido> vecinosPosibles = new ArrayList<NodoTendido>();
		vecinosPosibles.add(this.getNodo(coordenadaX+1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY+1));
		vecinosPosibles.add(this.getNodo(coordenadaX-1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY-1));

		boolean hayVecinos = false;
		Iterator<NodoTendido> iter = vecinosPosibles.iterator();

		while (iter.hasNext()){
			NodoTendido nodoActual = iter.next();
			if (nodoActual != null){
				hayVecinos = true;
				hacerVecinos (nodo, nodoActual);
			}
		}

		if (hayVecinos){
			this.nodos.add(nodo);
			return true;
		}
		return false;
	}

	public boolean agregarEdificioProveedor (int coordenadaX , int coordenadaY){
		Coordenada coord = new Coordenada(coordenadaX,coordenadaY);
		Iterator<Coordenada> iter = edificiosProveedores.iterator();
		Coordenada existente;
		while(iter.hasNext()) {
			existente = iter.next();
			if((coord.getX() == existente.getX()) &&
					(coord.getY() == existente.getY())){
				return false;
			}
		}
		this.edificiosProveedores.add (coord);
		return true;
	}

	public void eliminarEdificioProveedor(int x, int y) {

		Iterator<Coordenada> iter = this.edificiosProveedores.iterator();
		while (iter.hasNext()){
			Coordenada proveedorActual = iter.next();
			if ((proveedorActual.getX() == x) && (proveedorActual.getY() == y)){
				this.edificiosProveedores.remove(proveedorActual);
				break;
			}
		}

	}
	public boolean nodoExiste (int coordenadaX , int coordenadaY){
		if (this.getNodo(coordenadaX,coordenadaY) == null){
			return false;
		}
		return true;
	}

	public boolean eliminarNodo (NodoTendido nodo){

		if (nodo != null){
			quitarReferenciasDeVecinos(nodo);
			this.nodos.remove(nodo);
			return true;
		}
		return false;
	}

	public NodoTendido getNodo (int coordenadaX , int coordenadaY){
		Iterator<NodoTendido> iter = nodos.iterator();

		while ( iter.hasNext() ){

			NodoTendido nodoActual = iter.next();

			int XActual = nodoActual.getX();
			int YActual = nodoActual.getY();

			if ( (XActual == coordenadaX) && ( YActual == coordenadaY) ){
				return nodoActual;
			}
		}return null;
	}

	public int distanciaMinima(int XInicial, int YInicial, int XFinal, int YFinal){

		NodoTendido nodoInicial = this.getNodo(XInicial,YInicial);
		NodoTendido nodoFinal = this.getNodo(XFinal,YFinal);

		Hashtable<NodoTendido, Integer> distancias = distanciasMinimasDijkstra(nodoInicial);
		return (distancias.get(nodoFinal));
	}

	private void quitarReferenciasDeVecinos(NodoTendido nodo){

		int coordenadaX = nodo.getX();
		int coordenadaY = nodo.getY();

		nodo.borrarVecino(coordenadaX+1, coordenadaY);
		nodo.borrarVecino(coordenadaX, coordenadaY+1);
		nodo.borrarVecino(coordenadaX-1, coordenadaY);
		nodo.borrarVecino(coordenadaX, coordenadaY-1);

	}



	public void hacerVecinos (NodoTendido nodoNuevo, NodoTendido vecino){
		if ( vecino != null) {
			nodoNuevo.agregarVecino(vecino);
			vecino.agregarVecino(nodoNuevo);
		}
	}


	public boolean servicioExiste(int X, int Y) {

		Iterator<Coordenada> iter = edificiosProveedores.iterator();

		Coordenada coord;
		while (iter.hasNext()){
			coord = iter.next();
			if (this.existeConexionBFS(X, Y, coord.getX(), coord.getY() ) ){
				return true;
			}
		}
		return false;
	}

	public boolean regenerarNodo(NodoTendido nodo){

		int coordenadaX = nodo.getX();
		int coordenadaY = nodo.getY();
		if ( this.nodoExiste(coordenadaX,coordenadaY) )
			return false;

		ArrayList<NodoTendido> vecinosPosibles = new ArrayList<NodoTendido>();
		vecinosPosibles.add(this.getNodo(coordenadaX+1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY+1));
		vecinosPosibles.add(this.getNodo(coordenadaX-1, coordenadaY));
		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY-1));

		Iterator<NodoTendido> iter = vecinosPosibles.iterator();

		while (iter.hasNext()){
			NodoTendido nodoActual = iter.next();
			if (nodoActual != null){
				hacerVecinos (nodo, nodoActual);
			}
		}

		this.nodos.add(nodo);
		return true;
	}

	public boolean existeConexionBFS (int XInicial, int YInicial, int XFinal, int YFinal){
		//Implementa el algoritmo de recorrido BFS para saber si dos elementos se encuentran en el mismo subgrafo conexo.

		NodoTendido nodoInicial = this.getNodo(XInicial,YInicial);
		if (nodoInicial == null){
			return false;
		}
		NodoTendido nodoFinal = this.getNodo(XFinal,YFinal);

		ConcurrentLinkedQueue<NodoTendido> q = new ConcurrentLinkedQueue<NodoTendido>();
		Hashtable<NodoTendido, String> estadoVisitaNodo = new Hashtable<NodoTendido, String>();

		Iterator<NodoTendido> iter = nodos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();
			estadoVisitaNodo.put(nodoActual, "NO_VISITADO");
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
				if (estadoVisitaNodo.get(vecino) == "NO_VISITADO"){
					estadoVisitaNodo.put(vecino, "VISITADO");
					q.add(vecino);
				}
			}

		}return false;
	}

	private Hashtable<NodoTendido, Integer> distanciasMinimasDijkstra (NodoTendido nodoInicial){
		//Implementa el algoritmo de Dikjstra para calcular la distancia minimas entre cada elemento de un grafo conexo y un nodo inicial perteneciente al mismo.

		PriorityQueue<NodoTendido> q = new PriorityQueue<NodoTendido>();
		Hashtable<NodoTendido, Integer> distancias = new Hashtable<NodoTendido, Integer>();
		int INFINITO = Integer.MAX_VALUE;

		Iterator<NodoTendido> iter = nodos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();
			distancias.put(nodoActual, INFINITO);
		}

		distancias.put(nodoInicial, 0);
		q.add(nodoInicial);
		while (!q.isEmpty()){
			NodoTendido nodoActual = q.poll();
			ArrayList<NodoTendido> vecinos = nodoActual.getVecinos();
			Iterator<NodoTendido> iterVecinos = vecinos.iterator();
			while ( iterVecinos.hasNext() ){
				NodoTendido vecino = iterVecinos.next();
				if ( distancias.get(vecino) > distancias.get(nodoActual) + 1 ){
					distancias.put ( vecino , distancias.get(nodoActual) + 1);
					q.add(vecino);
				}
			}
		}
		return distancias;
	}


	public ArrayList<Coordenada> buscarEdificiosProveedoresBFS (int XInicial, int YInicial){

		NodoTendido nodoInicial = this.getNodo(XInicial,YInicial);
		ArrayList<Coordenada> edificiosBuscados = new ArrayList<Coordenada>();
		if (nodoInicial == null){
			return edificiosBuscados;
		}

		ConcurrentLinkedQueue<NodoTendido> q = new ConcurrentLinkedQueue<NodoTendido>();
		Hashtable<NodoTendido, String> estadoVisitaNodo = new Hashtable<NodoTendido, String>();

		Iterator<NodoTendido> iter = nodos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();
			estadoVisitaNodo.put(nodoActual, "NO_VISITADO");
		}

		estadoVisitaNodo.put(nodoInicial, "VISITADO");
		q.add(nodoInicial);

		while (!q.isEmpty()){
			NodoTendido nodoActual = q.poll();
			ArrayList<NodoTendido> vecinos = nodoActual.getVecinos();
			Iterator<NodoTendido> iterVecinos = vecinos.iterator();
			if (edificiosProveedores.contains(nodoActual) ){
				Coordenada coord = new Coordenada(nodoActual.getX(), nodoActual.getY());
				edificiosBuscados.add(coord);
			}
			while ( iterVecinos.hasNext() ){
				NodoTendido vecino = iterVecinos.next();
				if (estadoVisitaNodo.get(vecino) == "NO_VISITADO"){
					estadoVisitaNodo.put(vecino, "VISITADO");
					q.add(vecino);
				}
			}

		}
		return edificiosBuscados;
	}

	public abstract boolean setConexion(Hectarea hectarea, boolean estado);

}
