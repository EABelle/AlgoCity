package integracion;

import algocity.core.Mapa;
import algocity.core.Partida;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.CentralEolica;
import algocity.core.construibles.CentralMineral;
import algocity.core.construibles.EstacionDeBombero;
import algocity.core.construibles.PozoDeAgua;
import algocity.core.construibles.Residencial;
import junit.framework.TestCase;

public class IntegracionTest extends TestCase {
	
	public void test01agregarUnaCentralEolicaAlimenta4Hectareas() {
		
		Mapa mapa = new Mapa(10,10);
		
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		CentralEolica central = new CentralEolica();
		
		partida.agregarConstruible(central, 4, 4);
		
		assertTrue ((partida.redElectricaConectada(4, 4)));
		assertTrue ((partida.redElectricaConectada(1, 2)));
		assertTrue ((partida.redElectricaConectada(8, 8)));
		assertTrue ((partida.redElectricaConectada(0, 0)));
		assertTrue ((partida.redElectricaConectada(0, 8)));
		assertTrue ((partida.redElectricaConectada(8, 0)));
		assertFalse ((partida.redElectricaConectada(9, 9)));
	}
	
	public void test02agregarUnaCentralEolicaAEnElBordelimenta4Hectareas() {
		
		Mapa mapa = new Mapa(10,10);
		
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		CentralEolica central = new CentralEolica();
		
		partida.agregarConstruible(central, 0, 0);
		
		assertTrue ((partida.redElectricaConectada(0, 0)));
		assertTrue ((partida.redElectricaConectada(4, 4)));
		assertTrue ((partida.redElectricaConectada(0, 4)));
		assertTrue ((partida.redElectricaConectada(4, 0)));
		assertFalse ((partida.redElectricaConectada(5, 0)));
		assertFalse ((partida.redElectricaConectada(5, 4)));
		assertFalse ((partida.redElectricaConectada(9, 9)));
	}
	
	public void test03agregarUnaCentralYTendidoAlimentaTodoElTendido() {
		
		Mapa mapa = new Mapa(100,100);
		int i;
		
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		CentralMineral central = new CentralMineral();
		
		partida.agregarConstruible(central, 0, 0);
		
		for (i = 0; i <= 50; i ++) {
			partida.agregarConexionElectrica( 0, i);
		}
		
		assertTrue (partida.redElectricaConectada(0, 50));
		assertTrue (partida.redElectricaConectada(10, 10));
		assertFalse (partida.redElectricaConectada(1, 50));
		assertFalse (partida.redElectricaConectada(0, 51));
		
		partida.desconectarRedElectrica(0, 40);
		
		assertTrue (partida.redElectricaConectada(0, 50));
		
	}


	public void test04agregarUnPozoDeAguaYCanieriaAlimentaTodoLaCanieria() {
	
		Mapa mapa = new Mapa(100,100);
		int i;
		
		mapa.cargarHectareaNueva(new HectareaAgua());
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		PozoDeAgua pozo = new PozoDeAgua();
		
		partida.agregarConstruible(pozo, 0, 0);
		
		for (i = 0; i <= 73; i ++) {
			partida.agregarConexionDeAgua(0, i);
		}
		
		assertTrue (partida.redDeAguaConectada(0, 0));
		assertTrue (partida.redDeAguaConectada(0, 73));
		assertFalse (partida.redDeAguaConectada(0, 74));
		assertFalse (partida.redDeAguaConectada(1, 0));
	
	}

	public void test05NoSePuedeAgregarUnaCentralElectricaEnHectareaDeAgua() {
		
		Mapa mapa = new Mapa(100,100);
	
		
		mapa.cargarHectareaNueva(new HectareaAgua());
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		CentralEolica central = new CentralEolica();
		
		assertFalse(partida.agregarConstruible(central, 0, 0));
		
	}

	public void test06NoSePuedeAgregarUnPozoDeAguaEnHectareaLlana() {
		
		Mapa mapa = new Mapa(100,100);
	
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		PozoDeAgua pozo = new PozoDeAgua();
		
		assertFalse(partida.agregarConstruible(pozo, 0, 0));
		
	}

	public void test07RepararResidencialConectadoAumentaUn10Porciento(){
		
		Mapa mapa = new Mapa(100,100);
		
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		Residencial residencial = new Residencial();
		
		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(residencial, 0, 10);
		
		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRuta(0, j);
		}
		
		residencial.daniar(10);
		
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertFalse (residencial.daniado());
	}

	public void test08RepararResidencialConectadoABomberosAumentaUn20PorcientoEn2Turnos(){
		
		Mapa mapa = new Mapa(100,100);
		
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		Residencial residencial = new Residencial();
		
		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		//partida.agregarConstruible(new EstacionDeBombero(), 0, 5);
		partida.agregarConstruible(residencial, 0, 10);
		
		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRuta(0, j);
		}
		
		residencial.daniar(20);
		
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertFalse (residencial.daniado());
	}
	
	public void test09RepararResidencialConectadoA2BomberosAumentaUn20Porciento(){
		
		Mapa mapa = new Mapa(100,100);
		
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}
		
		Partida partida = new Partida(mapa);
		Residencial residencial = new Residencial();
		
		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(new EstacionDeBombero(), 10, 0);
		partida.agregarConstruible(residencial, 0, 10);
		
		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRuta(0, j);
		}
		
		for (j = 0; j <= 10; j ++) {
			partida.agregarRuta(j, 0);
		}
		
		residencial.daniar(20);
		
		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertFalse (residencial.daniado());
		/*no esta usando los dos bomberos, mirar el procesamiento al agregar 
		 * bomberos y ruta.mandarBomberos*/
	}
}
