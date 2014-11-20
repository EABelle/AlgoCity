package algocity.core.procesadores;

import junit.framework.TestCase;
import algocity.core.Configuracion;
import algocity.core.HectareasFactory;

public class CalculadorDeCalidadDeVidaTest extends TestCase {
	
	CalculadorDeCalidadDeVida calc;
	HectareasFactory fact;
	
	public void setUp() {
		calc = new CalculadorDeCalidadDeVida();
		fact = new HectareasFactory();
	}
	
	public void testCalculadorDeVidaComienzaConUnIndice() {
		assertEquals(calc.getIndice(), Configuracion.IndiceVidaInicial);
	}
	
	public void testIndiceSeMantiene() {
		calc.procesarHectarea(fact.getHectareaConComercial());
		calc.procesarHectarea(fact.getHectareaConIndustrial());
		calc.procesarHectarea(fact.getHectareaConResidencial());
		calc.finalizarProceso();
		assertEquals(calc.getIndice(), Configuracion.IndiceVidaInicial);
	}
	
	public void testIndiceBaja() {
		calc.procesarHectarea(fact.getHectareaConResidencial());
		calc.procesarHectarea(fact.getHectareaConResidencial());
		calc.finalizarProceso();
		assertEquals(Configuracion.IndiceVidaInicial - 2, calc.getIndice());
	}

}
