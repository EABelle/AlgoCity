package algocity.core.construibles;

public abstract class Edificio {
	protected  int costo;
	protected int consumoElectrico;
	
	public void Edificio (int costo, int consumoElectrico){
		this.costo = costo;
		this.consumoElectrico = consumoElectrico;
	}

}
