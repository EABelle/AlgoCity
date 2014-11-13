package algocity.core.capas.tendido;

import junit.framework.TestCase;

public class RutaPavimentadaTest extends TestCase{

	public void test01CrearRutaVacia() {
		RutaPavimentada ruta = new RutaPavimentada();
		NodoTendido nodo = ruta.getNodo(2,3);
		assertTrue( nodo == null );
		
	}
	public void test02SePuedeAgregarNodo(){
		RutaPavimentada ruta = new RutaPavimentada();
		
		boolean seAgregoElNodo = ruta.agregarNodo(2,3);
				
		NodoTendido nodoNuevo = ruta.getNodo(2,3);
		
		assertTrue(seAgregoElNodo);
		assertTrue(nodoNuevo != null);
	}
	
	public void test03SePuedeAgregarNodoSinNodoVecino(){
		
		RutaPavimentada ruta = new RutaPavimentada();

		ruta.agregarNodo(3,3);
		
		boolean seAgregoElNodo = ruta.agregarNodo(5,5);
		NodoTendido nodoNuevo = ruta.getNodo(5,5);

		assertTrue(seAgregoElNodo);
		assertTrue( nodoNuevo != null );
	}
	
	public void test04AgregarDosNodosNoConectados(){
		
		RutaPavimentada ruta = new RutaPavimentada();
		ruta.agregarNodo(3,3);
		ruta.agregarNodo(5,3);
		
		assertFalse( ruta.existeConexionBFS(3, 3, 5, 3) );
		
	}

	public void test05AgregarDosNodosYConectarlosConOtro(){
		
		RutaPavimentada ruta = new RutaPavimentada();
		ruta.agregarNodo(3,3);
		ruta.agregarNodo(5,3);
		assertFalse( ruta.existeConexionBFS(3, 3, 5, 3) );
		
		ruta.agregarNodo(4,3);
		assertTrue( ruta.existeConexionBFS(3, 3, 5, 3) );
		
	}
	
	public void test06AgregarTresNodosConectadosEliminarElDelMedioYYaNoEstanConectados(){
		
		RutaPavimentada ruta = new RutaPavimentada();
		ruta.agregarNodo(3,3);
		ruta.agregarNodo(4,3);
		ruta.agregarNodo(5,3);
		assertTrue( ruta.existeConexionBFS(3, 3, 5, 3) );
		
		ruta.eliminarNodo(4, 3);
		assertFalse( ruta.existeConexionBFS(3, 3, 5, 3) );
		
	}
	
	public void test07RomperCaminoYVolverAAgregarNodo(){
		
		RutaPavimentada ruta = new RutaPavimentada();
		ruta.agregarNodo(3,3);
		ruta.agregarNodo(4,3);
		ruta.agregarNodo(5,3);
		assertTrue( ruta.existeConexionBFS(3, 3, 5, 3) );
		
		ruta.eliminarNodo(4, 3);
		assertFalse( ruta.existeConexionBFS(3, 3, 5, 3) );
		
		ruta.agregarNodo(4,3);
		assertTrue( ruta.existeConexionBFS(3, 3, 5, 3) );
			
	}
}

