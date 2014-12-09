package algocity.core.capas.tendido;

import java.util.ArrayList;

import junit.framework.TestCase;
import algocity.core.capas.tendido.NodoTendido;

public class NodoTendidoTest extends TestCase {

	public void testCrearNodoTendidoConCoordenadas() {
		NodoTendido nodo = new NodoTendido (2,3);
		int coordenadaX = nodo.getX();
		int coordenadaY = nodo.getY();
		
		assertEquals(coordenadaX,2);
		assertEquals(coordenadaY,3);
		
	}
	
	public void testAgregar1Vecino() {
		NodoTendido nodo = new NodoTendido (2,3);
		NodoTendido vecino = new NodoTendido (3,3);
		
		nodo.agregarVecino(vecino);
		ArrayList<NodoTendido> vecinos = nodo.getVecinos();
		
		assertTrue(vecinos.contains(vecino));
	}

	public void testBorrarVecino() {
		NodoTendido nodo = new NodoTendido (2,3);
		NodoTendido vecino = new NodoTendido (5,2);
		
		nodo.agregarVecino(vecino);
		ArrayList<NodoTendido> vecinos = nodo.getVecinos();
		
		assertTrue(vecinos.contains(vecino));	
		
		nodo.borrarVecino(5,2);
		assertFalse(vecinos.contains(vecino));
	}	
}
