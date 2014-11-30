package algocity.core.capas.tendido;



import java.util.ArrayList;
import java.util.Iterator;

public class RedDeAgua extends Tendido {

	@Override
	public boolean agregarNodo(int coordenadaX, int coordenadaY){
		
		if ( this.nodoExiste(coordenadaX,coordenadaY) )
			return false;
		
		NodoTendido nodoNuevo = new NodoTendido(coordenadaX, coordenadaY);
		
		/*--------------------------------------------------------------------------------------------
		 * Agrega el nodo si son las coordenadas de una central
		 *------------------------------------------------------------------------------------------*/
		Iterator<Coordenada> iter2 = edificiosProveedores.iterator();
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
				hacerVecinos (nodoNuevo, nodoActual);
			}
		}
		
		if (hayVecinos){
			this.nodos.add(nodoNuevo);
			return true;
		}
		return false;

	}


//	@Override
//	public boolean agregarNodo(int coordenadaX, int coordenadaY){
//		
//		if ( this.nodoExiste(coordenadaX,coordenadaY) )
//			return false;
//		
//		NodoTendido nodoNuevo = new NodoTendido(coordenadaX, coordenadaY);
//		
//		ArrayList<NodoTendido> vecinosPosibles = new ArrayList<NodoTendido>(); 
//		vecinosPosibles.add(this.getNodo(coordenadaX+1, coordenadaY));
//		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY+1));
//		vecinosPosibles.add(this.getNodo(coordenadaX-1, coordenadaY));
//		vecinosPosibles.add(this.getNodo(coordenadaX, coordenadaY-1));
//		
//		
//		/*--------------------------------------------------------------------------------------------
//		 * Agrega el nodo si son las coordenadas de un pozo
//		 *------------------------------------------------------------------------------------------*/
//		Iterator<Coordenada> iter2 = edificiosProveedores.iterator();
//		while (iter2.hasNext()){
//			Coordenada coordenadaActual = iter2.next();
//			if ( (coordenadaActual.getX() == coordenadaX) && (coordenadaActual.getY() == coordenadaY) ){
//				this.nodos.add(nodoNuevo);
//				return true;
//			}
//		}
//
//		/*--------------------------------------------------------------------------------------------
//		 * Agrega el nodo si solo hay un nodo vecino (es extremo)
//		 *------------------------------------------------------------------------------------------*/
//		
//		Iterator<NodoTendido> iter = vecinosPosibles.iterator();
//		while (iter.hasNext()){
//			NodoTendido nodoActual = iter.next();
//			if (nodoActual != null){
//				if (nodoActual.getVecinos().size() <= 1){
//					hacerVecinos (nodoNuevo, nodoActual);
//					this.nodos.add(nodoNuevo);
//					return true;
//				}
//			}
//		}
//		
//		/*if ( count >= 1 ){
//			Iterator<NodoTendido>iter3 = vecinosPosibles.iterator();
//			vecino = iter3.next();
//			if (vecino.getVecinos().size() == 1){
//				hacerVecinos (nodoNuevo, vecino);
//				this.nodos.add(nodoNuevo);
//				return true;
//			}
//		}*/
//		return false;
//	}
//

}