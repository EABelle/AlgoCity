package algocity.core.capas.tendido;

import junit.framework.TestCase;
import algocity.core.capas.tendido.Tendido;


public class TendidoTest extends TestCase{

	public void testCrearTendidoVacio() {
		Tendido tendido = new Tendido();
		NodoTendido nodo = tendido.getNodo(2,3);
		assertTrue( nodo == null );
		
	}
	
	public void testCrearTendidoYAgregarNodo() {
		Tendido tendido = new Tendido();
		tendido.agregarNodo(2,3);
		
		NodoTendido nodo = tendido.getNodo(2,3);
		assertTrue( nodo != null );
		
	}
	
	public void testCrearTendidoYAgregarDosNodos() {
		Tendido tendido = new Tendido();
		tendido.agregarNodo(2,3);
		tendido.agregarNodo(3,3);
		
		
		NodoTendido nodo1 = tendido.getNodo(4,4);
		NodoTendido nodo2 = tendido.getNodo(2,3);
		NodoTendido nodo3 = tendido.getNodo(3,3);

		assertTrue( nodo1 == null );
		assertTrue( nodo2 != null );
		assertTrue( nodo3 != null );
		
	}
	
	public void testCrearTendidoYAgregarDosNodosConectados() {
		Tendido tendido = new Tendido();
		tendido.agregarNodo(2,3);
		tendido.agregarNodo(3,3);
		
		
		NodoTendido nodo1 = tendido.getNodo(2,3);
		NodoTendido nodo2 = tendido.getNodo(3,3);

		assertTrue( tendido.existeConexionBFS(nodo1, nodo2) );
		
	}
	
	public void testCrearTendidoYAgregarDosNodosNOConectados() {
		Tendido tendido = new Tendido();
		tendido.agregarNodo(2,3);
		tendido.agregarNodo(5,5);
		
		NodoTendido nodo1 = tendido.getNodo(2,3);
		NodoTendido nodo2 = tendido.getNodo(5,5);

		assertFalse( tendido.existeConexionBFS(nodo1, nodo2) );
		
	}
	

}
