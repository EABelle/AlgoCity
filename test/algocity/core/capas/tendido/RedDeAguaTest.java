package algocity.core.capas.tendido;

import junit.framework.TestCase;


public class RedDeAguaTest extends TestCase{

	public void test01CrearRedVacia() {
		RedDeAgua red = new RedDeAgua();
		NodoTendido nodo = red.getNodo(2,3);
		assertTrue( nodo == null );
		
	}
	
	public void test02NoSePuedeAgregarNodoSinPozo(){
		RedDeAgua red = new RedDeAgua();
		
		boolean seAgregoElNodo = red.agregarNodo(2,3);
				
		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(2,3);
		
		assertTrue(!seAgregoElNodo);
		assertTrue( nodoQueNoSePuedeAgregar == null );
		
	}
	
	public void test03CrearRedLuegoAgregarPozoYNodo(){
		
		RedDeAgua red = new RedDeAgua();
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		
		NodoTendido nodoAgregado = red.getNodo(3,3);

		assertTrue( nodoAgregado != null );
	}
	
	public void test04NoSePuedeAgregarNodoSinNodoVecino(){
		
		RedDeAgua red = new RedDeAgua();
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		
		boolean seAgregoElNodo = red.agregarNodo(5,5);
		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(5,5);

		assertTrue(!seAgregoElNodo);
		assertTrue( nodoQueNoSePuedeAgregar == null );
		
	}
	
	public void test05AgregarNodoVecino(){
		
		RedDeAgua red = new RedDeAgua();
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		red.agregarNodo(4,3);
		
		NodoTendido nodoVecino = red.getNodo(4,3);
		assertTrue( nodoVecino != null );
	}
	
	public void test06NoSePuedeAgregarNodoDondeYaHay() throws NoHayNodoCercanoException, NodoExistenteException{
		
		boolean seAgregoElNodo = false;
		
		RedDeAgua red = new RedDeAgua();
		
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		
		seAgregoElNodo = red.agregarNodo(3,3);
				
		assertTrue(!seAgregoElNodo);
	}
}
