package algocity.core.capas.tendido;

import junit.framework.TestCase;


public class RedDeAguaTest extends TestCase{

	public void test01CrearRedVacia() {
		RedDeAgua red = new RedDeAgua();
		NodoTendido nodo = red.getNodo(2,3);
		assertTrue( nodo == null );
		
	}
	
	public void test02NoSePuedeAgregarNodoSinPozo() throws NodoExistenteException{
		RedDeAgua red = new RedDeAgua();
		
		try {
			
			red.agregarNodo(2,3);
		} 
		catch (NoHayNodoCercanoException e){}
		
		NodoTendido nodo = red.getNodo(2,3);
		assertTrue( nodo == null );
		
	}
	
	public void test03CrearRedLuegoAgregarPozoYNodo() throws NoHayNodoCercanoException, NodoExistenteException{
		
		RedDeAgua red = new RedDeAgua();
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		
		NodoTendido nodo = red.getNodo(3,3);

		assertTrue( nodo != null );
	}
	
	public void test04NoSePuedeAgregarNodoSinNodoVecino() throws NoHayNodoCercanoException, NodoExistenteException{
		
		RedDeAgua red = new RedDeAgua();
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		
		try {
			red.agregarNodo(5,5);
		} catch (NoHayNodoCercanoException e) {}
		
		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(5,5);

		assertTrue( nodoQueNoSePuedeAgregar == null );
		
	}
	
	public void test05AgregarNodoVecino() throws NoHayNodoCercanoException, NodoExistenteException{
		
		RedDeAgua red = new RedDeAgua();
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		red.agregarNodo(4,3);
		
		
		NodoTendido nodoVecino = red.getNodo(4,3);

		assertTrue( nodoVecino != null );
		
	
		
	}
	
	public void test06NoSePuedeAgregarNodoDondeYaHay() throws NoHayNodoCercanoException, NodoExistenteException{
		
		boolean sePudo = false;
		
		RedDeAgua red = new RedDeAgua();
		
		red.agregarPozo(3,3);
		red.agregarNodo(3,3);
		try {
			
			red.agregarNodo(3,3);
			sePudo = true;
			
		} catch (NodoExistenteException e) {}
		
		assertTrue( sePudo == false);
	}
}
