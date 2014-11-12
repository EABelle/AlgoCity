package algocity.core.capas;

import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.Comercial;
import algocity.core.construibles.Residencial;

public class HectareaLlanaTest {
	
	public void testCrearHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
	}
	
	public void testSeAgregaResidecialEnHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
		llanura.agregarConstruible(new Residencial());
	}
	
	public void testSeAgregaComercialEnHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
		llanura.agregarConstruible (new Comercial());
	}

}
