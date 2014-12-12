package integracion;

import junit.framework.TestCase;
import algocity.core.Mapa;
import algocity.core.Partida;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.CentralEolica;
import algocity.core.construibles.CentralMineral;
import algocity.core.construibles.CentralNuclear;
import algocity.core.construibles.EstacionDeBombero;
import algocity.core.construibles.PozoDeAgua;
import algocity.core.construibles.Residencial;

public class IntegracionTest extends TestCase {

	public void test01agregarUnaCentralEolicaAlimenta4Hectareas() {

		Mapa mapa = new Mapa(10,10);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
			mapa.cargarHectareaNueva(new HectareaAgua());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		CentralEolica central = new CentralEolica();
		PozoDeAgua pozo = new PozoDeAgua();

		partida.agregarConstruible(central, 4, 4);
		partida.agregarConstruible(pozo, 4, 5);
		partida.agregarRedDeAgua(4, 5);
		partida.agregarRedDeAgua(4, 4);

		assertTrue ((mapa.getHectarea(4, 4).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(1, 2).redElectricaConectada()));
		assertFalse ((mapa.getHectarea(1, 1).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(0, 0).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(8, 0).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(0, 8).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(8, 8).redElectricaConectada()));
		assertFalse ((mapa.getHectarea(9, 9).redElectricaConectada()));
	}

	public void test02agregarUnaCentralEolicaAEnElBordelimenta4Hectareas() {

		Mapa mapa = new Mapa(10,10);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
			mapa.cargarHectareaNueva(new HectareaAgua());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		CentralEolica central = new CentralEolica();
		PozoDeAgua pozo = new PozoDeAgua();

		partida.agregarConstruible(central, 0, 0);
		partida.agregarConstruible(pozo, 0, 1);
		partida.agregarRedDeAgua(0, 1);
		partida.agregarRedDeAgua(0, 0);

		assertTrue ((mapa.getHectarea(4, 4).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(0, 4).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(0, 0).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(4, 0).redElectricaConectada()));
		assertFalse ((mapa.getHectarea(5, 0).redElectricaConectada()));
		assertFalse ((mapa.getHectarea(5, 4).redElectricaConectada()));
		assertFalse ((mapa.getHectarea(9, 9).redElectricaConectada()));
	}

	public void test03agregarUnaCentralYTendidoAlimentaTodoElTendido() {

		Mapa mapa = new Mapa(100,100);
		int i;

		mapa.cargarHectareaNueva(new HectareaAgua());
		mapa.cargarHectareaNueva(new HectareaLlana());
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		CentralMineral central = new CentralMineral();
		PozoDeAgua pozo = new PozoDeAgua();

		partida.agregarConstruible(central, 0, 1);
		partida.agregarConstruible(pozo, 0, 0);
		partida.agregarRedDeAgua(0, 0);
		partida.agregarRedDeAgua(0, 1);

		for (i = 1; i <= 50; i ++) {
			partida.agregarRedElectrica(0, i);
		}

		assertTrue ((mapa.getHectarea(0, 50).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(0, 40).redElectricaConectada()));
		assertTrue ((mapa.getHectarea(10, 10).redElectricaConectada()));

		partida.quitarRedElectrica(0, 40);

		assertFalse ((mapa.getHectarea(0, 50).redElectricaConectada()));

	}


	public void test04agregarUnPozoDeAguaYCanieriaAlimentaTodoLaCanieria() {

		Mapa mapa = new Mapa(100,100);
		int i;

		mapa.cargarHectareaNueva(new HectareaAgua());
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		PozoDeAgua pozo = new PozoDeAgua();

		partida.agregarConstruible(pozo, 0, 0);

		for (i = 0; i <= 73; i ++) {
			partida.agregarRedDeAgua(0, i);
		}
		assertTrue ((mapa.getHectarea(0, 0).redDeAguaConectada()));
		assertTrue ((mapa.getHectarea(0, 73).redDeAguaConectada()));
		assertFalse ((mapa.getHectarea(0, 74).redDeAguaConectada()));

	}

	public void test05NoSePuedeAgregarUnaCentralElectricaEnHectareaDeAgua() {

		Mapa mapa = new Mapa(100,100);


		mapa.cargarHectareaNueva(new HectareaAgua());
		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		CentralEolica central = new CentralEolica();

		assertFalse(partida.agregarConstruible(central, 0, 0));

	}

	public void test06NoSePuedeAgregarUnPozoDeAguaEnHectareaLlana() {

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		PozoDeAgua pozo = new PozoDeAgua();

		assertFalse(partida.agregarConstruible(pozo, 0, 0));

	}

	public void test07RepararResidencialConectadoAumentaUn10Porciento(){

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		Residencial residencial = new Residencial();

		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(residencial, 0, 10);

		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(0, j);
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
		partida.inicializar();
		Residencial residencial = new Residencial();

		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(residencial, 0, 10);

		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(0, j);
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
		partida.inicializar();
		Residencial residencial = new Residencial();

		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(new EstacionDeBombero(), 10, 0);
		partida.agregarConstruible(residencial, 0, 10);

		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(0, j);
		}

		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(j, 0);
		}

		residencial.daniar(20);

		assertTrue (residencial.daniado());
		partida.pasarTurno();
		assertFalse (residencial.daniado());

	}

public void test10UnaEstacionDeBomberoReparaTodosLosEdificiosALosQueSeConecta(){

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		Residencial residencial = new Residencial();
		CentralNuclear central = new CentralNuclear();


		int j;
		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(0, j);
		}

		for (j = 0; j <= 10; j ++) {
			partida.agregarRutaPavimentada(j, 0);
		}

		residencial.daniar(10);
		central.daniar(1);

		partida.agregarConstruible(new EstacionDeBombero(), 0, 0);
		partida.agregarConstruible(central, 10, 0);
		partida.agregarConstruible(residencial, 0, 10);


		assertTrue (residencial.daniado());
		assertTrue (central.daniado());

		partida.pasarTurno();

		assertFalse (residencial.daniado());
		assertFalse (central.daniado());

	}

	public void test11NoPuedoExcedermeEnGastos(){

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		Residencial residencial1 = new Residencial();
		Residencial residencial2 = new Residencial();
		CentralNuclear central1 = new CentralNuclear();
		CentralNuclear central2 = new CentralNuclear();


		assertTrue (partida.agregarConstruible(central1, 10, 0));
		assertTrue (partida.agregarConstruible(residencial1, 0, 10));
		assertFalse (partida.agregarConstruible(central2, 10, 1));
		assertTrue (partida.agregarConstruible(residencial2, 1, 10));
	}


	public void test12NoPuedoConstruirDosConstruiblesEnElMismoLugar(){

		Mapa mapa = new Mapa(100,100);

		while (!mapa.cargado()) {
			mapa.cargarHectareaNueva(new HectareaLlana());
		}

		Partida partida = new Partida(mapa);
		partida.inicializar();
		Residencial residencial1 = new Residencial();
		Residencial residencial2 = new Residencial();


		assertTrue (partida.agregarConstruible(residencial1, 0, 10));
		assertFalse (partida.agregarConstruible(residencial2, 0, 10));
		assertTrue (partida.agregarConstruible(residencial2, 1, 10));
	}
}