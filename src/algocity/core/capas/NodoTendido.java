package algocity.core.capas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public abstract class NodoTendido extends Observable{

	protected int x;
	protected int y;
	ArrayList<NodoTendido> vecinos;


	public NodoTendido() {
		this.vecinos = new ArrayList<NodoTendido>();
	}

	public void agregarVecino (NodoTendido vecino){
		this.vecinos.add(vecino);
	}

	public ArrayList<NodoTendido> getVecinos (){
		return this.vecinos;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}

	public void borrarVecino (int coordenadaX , int coordenadaY){
		Iterator<NodoTendido> iter = this.vecinos.iterator();
		while ( iter.hasNext() ){
			NodoTendido nodoActual = iter.next();

			int XActual = nodoActual.getX();
			int YActual = nodoActual.getY();

			if ( (XActual == coordenadaX) && (YActual == coordenadaY) ){
				this.vecinos.remove(nodoActual);
				return;
			}
		}
	}
}
