package algocity.core.construibles;

public class EstacionDeBombero extends ConstruibleEnLlano {
	
	public void reparar(Residencial residencial) {
		residencial.reparar(10);
	}
	
	public void reparar(Comercial comercial) {
		comercial.reparar(7);
	}
	
	public void reparar(Industrial industrial) {
		industrial.reparar(3);
	}
	
	public void reparar(CentralEolica central) {
		central.reparar(15);
	}
	
	public void reparar(CentralMineral central) {
		central.reparar(10);
	}
	
	public void reparar(CentralNuclear central) {
		central.reparar(3);
	}

}
