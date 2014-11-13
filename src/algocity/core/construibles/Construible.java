package algocity.core.construibles;

public abstract class Construible {

	protected int costo;
	private int porcentajeDeVida;
	private boolean cumpleRedDeAgua;
	private boolean cumpleRedElectrica;
	private boolean cumpleRutaPavimentada;
	
	public Construible() {
		porcentajeDeVida = 100;
		cumpleRedDeAgua = false;
		cumpleRedElectrica = false;
		cumpleRutaPavimentada = false;
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