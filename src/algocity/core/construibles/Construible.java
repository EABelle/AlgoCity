package algocity.core.construibles;

public abstract class Construible {

	protected int costo;
	private int porcentajeDeVida;
	
	public Construible() {
		porcentajeDeVida = 100;
	}
	
	public void daniar (int porcentajeDeDanio) {
		if ((porcentajeDeVida -=  porcentajeDeDanio) < 0) {
			porcentajeDeVida = 0;
		}
	}
	
	public void reparar (int porcentajeDeReparo) {
		if ((porcentajeDeVida +=  porcentajeDeReparo) > 100) {
			porcentajeDeVida = 100;
		}
	}
	
	public int getCosto() {
		return costo;
	}
	
}