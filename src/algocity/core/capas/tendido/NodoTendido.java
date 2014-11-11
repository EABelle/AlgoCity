package algocity.core.capas.tendido;

import java.util.ArrayList;
import java.util.Iterator;

public class NodoTendido {
	
	int coordenadaX;
	int coordenadaY;
	ArrayList<NodoTendido> vecinos;

	
	public NodoTendido(int coordenadaX, int coordenadaY) {
		
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.vecinos = new ArrayList<NodoTendido>();
	}
	
	public void agregarVecino (NodoTendido vecino){		
		this.vecinos.add(vecino);
	}

	public ArrayList<NodoTendido> getVecinos (){
		return this.vecinos;
	}
	
	public int getCoordenadaX (){
		return this.coordenadaX;
	}

	public int getCoordenadaY (){
		return this.coordenadaY;
	}
	
	public void borrarVecino (int coordenadaX , int coordenadaY){
		Iterator<NodoTendido> iter = this.vecinos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();
			
			int XActual = nodoActual.getCoordenadaX();
			int YActual = nodoActual.getCoordenadaY();
			
			if ( (XActual == coordenadaX) && (YActual == coordenadaY) ){
				this.vecinos.remove(nodoActual);
				return;
			}
		}
	}
}
