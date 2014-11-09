package fiuba.algo3.edificios;

public abstract class Edificio {
	protected  int costo;
	protected int consumoElectrico;
	
	public void Edificio (int costo, int consumoElectrico){
		this.costo = costo;
		this.consumoElectrico = consumoElectrico;
	}

}
