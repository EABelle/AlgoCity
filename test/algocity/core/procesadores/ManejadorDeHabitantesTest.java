package algocity.core.procesadores;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.Residencial;
import junit.framework.TestCase;

public class ManejadorDeHabitantesTest extends TestCase {
	
	ManejadorDeHabitantes manejador;
	
	public void setUp() {
		manejador = new ManejadorDeHabitantes();
	}
	
	public Hectarea obtenerHectareaConCasa() {
		HectareaLlana hectarea = new HectareaLlana();
		Residencial casa = new Residencial();
		casa.conectarARedDeAgua();
		casa.conectarARedElectrica();
		casa.conectarARutaPavimentada();
		hectarea.agregarConstruible(casa);
		return hectarea;
	}
	
	public void testSeLePuedenSetearHabitantes() {
		manejador.setHabitantes(100);
		assertEquals(100, manejador.getHabitantes());
	}
	
	public void testAgregaHabitantesAlEdificio() {
		manejador.setHabitantes(100);
		Hectarea hectarea = obtenerHectareaConCasa();
		manejador.procesarHectarea(hectarea);
		manejador.finalizarProceso();
		assertEquals(0, manejador.getHabitantes());
		assertEquals(0, ((Residencial) hectarea.getConstruible()).disponibilidad());
	}
	
	public void testAgregaHabitantesAVariosEdificios() {
		Hectarea hectarea = obtenerHectareaConCasa();
		Hectarea hectarea2 = obtenerHectareaConCasa();
		Residencial casa = (Residencial) hectarea.getConstruible();
		Residencial casa2 = (Residencial) hectarea2.getConstruible();
		manejador.setHabitantes(300);
		manejador.procesarHectarea(hectarea);
		manejador.procesarHectarea(hectarea2);
		manejador.finalizarProceso();
		assertEquals(100, manejador.getHabitantes());
		assertEquals(0, casa.disponibilidad());
		assertEquals(0, casa2.disponibilidad());
		
	}

}
