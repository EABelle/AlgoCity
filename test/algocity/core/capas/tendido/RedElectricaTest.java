package algocity.core.capas.tendido;

import junit.framework.TestCase;
import algocity.core.capas.NodoTendido;

public class RedElectricaTest extends TestCase{

	public void test01CrearRedVacia() {
		RedElectrica red = new RedElectrica();
		NodoTendido nodo = red.getNodo(2,3);
		assertTrue( nodo == null );

	}

	public void test02NoSePuedeAgregarNodoSinCentral(){
		RedElectrica red = new RedElectrica();

		boolean seAgregoElNodo = red.agregarNodo(new NodoTendido(2, 3));

		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(2,3);

		assertTrue(!seAgregoElNodo);
		assertTrue( nodoQueNoSePuedeAgregar == null );

	}

	public void test03CrearRedLuegoAgregarCentralYNodo(){

		RedElectrica red = new RedElectrica();
		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));

		NodoTendido nodoAgregado = red.getNodo(3,3);

		assertTrue( nodoAgregado != null );
	}

	public void test04NoSePuedeAgregarNodoSinNodoVecino(){

		RedElectrica red = new RedElectrica();
		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));

		boolean seAgregoElNodo = red.agregarNodo(new NodoTendido(5, 5));
		NodoTendido nodoQueNoSePuedeAgregar = red.getNodo(5,5);

		assertTrue(!seAgregoElNodo);
		assertTrue( nodoQueNoSePuedeAgregar == null );

	}

	public void test05AgregarNodoVecino(){

		RedElectrica red = new RedElectrica();
		red.agregarEdificioProveedor(3,3);
		red.agregarNodo(new NodoTendido(3, 3));
		red.agregarNodo(new NodoTendido(4, 3));

		NodoTendido nodoVecino = red.getNodo(4,3);
		assertTrue( nodoVecino != null );
	}

	public void test06NoSePuedeAgregarNodoDondeYaHay(){

		boolean seAgregoElNodo = false;

		RedElectrica red = new RedElectrica();

		red.agregarEdificioProveedor(3, 3);
		red.agregarNodo(new NodoTendido(3, 3));

		seAgregoElNodo = red.agregarNodo(new NodoTendido(3, 3));

		assertTrue(!seAgregoElNodo);
	}

	public void test07NoSePuedeEliminarNodoQueNoEsta(){

		RedElectrica red = new RedElectrica();
		red.eliminarNodo(new NodoTendido(2, 3));
	}


}
