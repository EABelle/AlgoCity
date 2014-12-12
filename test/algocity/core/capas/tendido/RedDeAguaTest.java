package algocity.core.capas.tendido;

import junit.framework.TestCase;
import algocity.core.capas.NodoTendido;


public class RedDeAguaTest extends TestCase{

	public void test01CrearRedVacia() {
		RedDeAgua red = new RedDeAgua();
		NodoTendido nodo = red.getNodo(2,3);
		assertTrue( nodo == null );

	}

	public void test02NoSePuedeAgregarNodoSinPozo(){
		RedDeAgua red = new RedDeAgua();

		NodoTendido nodo = new NodoTendido(2, 3);
		boolean seAgregoElNodo = red.agregarNodo(nodo);

		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(2,3);

		assertTrue(!seAgregoElNodo);
		assertTrue( nodoQueNoSePuedeAgregar == null );

	}

	public void test03CrearRedLuegoAgregarPozoYNodo(){

		RedDeAgua red = new RedDeAgua();
		red.agregarEdificioProveedor(3, 3);
		red.agregarNodo(new NodoTendido(3, 3));

		NodoTendido nodoAgregado = red.getNodo(3,3);

		assertTrue( nodoAgregado != null );
	}

	public void test04NoSePuedeAgregarNodoSinNodoVecino(){

		RedDeAgua red = new RedDeAgua();
		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));

		boolean seAgregoElNodo = red.agregarNodo(new NodoTendido(5, 5));
		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(5,5);

		assertTrue(!seAgregoElNodo);
		assertTrue( nodoQueNoSePuedeAgregar == null );

	}

	public void test05AgregarNodoVecino(){

		RedDeAgua red = new RedDeAgua();
		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));
		red.agregarNodo(new NodoTendido(4, 3));

		NodoTendido nodoVecino = red.getNodo(4,3);
		assertTrue( nodoVecino != null );
		assertTrue(red.servicioExiste(4,3));
	}

	public void test06NoSePuedeAgregarNodoDondeYaHay(){

		boolean seAgregoElNodo = false;

		RedDeAgua red = new RedDeAgua();

		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));

		seAgregoElNodo = red.agregarNodo(new NodoTendido(3, 3));

		assertTrue(!seAgregoElNodo);
	}

	public void test07agregaDosNodosSeparadosNoEstanConectados(){

		RedDeAgua red = new RedDeAgua();

		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));
		red.agregarNodo(new NodoTendido(6, 6));

		assertFalse(red.servicioExiste(6, 6));



	}
}
