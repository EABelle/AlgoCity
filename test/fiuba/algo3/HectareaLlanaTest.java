package fiuba.algo3;

import fiuba.algo3.edificios.Comercial;
import fiuba.algo3.edificios.Residencial;

public class HectareaLlanaTest {
	
	public void testCrearHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
	}
	
	public void testSeAgregaResidecialEnHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
		llanura.agregarEdificio (new Residencial());
	}
	
	public void testSeAgregaComercialEnHectareaLlana(){
		HectareaLlana llanura = new HectareaLlana();
		llanura.agregarEdificio (new Comercial());
	}

}
