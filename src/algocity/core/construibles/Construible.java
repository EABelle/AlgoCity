package algocity.core.construibles;

public abstract class Construible {

	protected int costo;
	private int porcentajeDeVida;
	protected boolean cumpleRedDeAgua;
	protected boolean cumpleRedElectrica;
	protected boolean cumpleRutaPavimentada;
	
	public Construible() {
		porcentajeDeVida = 100;
		cumpleRedDeAgua = true;
		cumpleRedElectrica = true;
		cumpleRutaPavimentada = true;
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
	
	public boolean cumpleRequerimientos(){
		if (cumpleRedDeAgua && cumpleRedElectrica && cumpleRutaPavimentada){
			return true;
		}
		return false;
	}
	
	public void conectarARedDeAgua(){
		cumpleRedDeAgua = true;
	}
	
	public void conectarARedElectrica(){
		cumpleRedElectrica = true;
	}
	
	public void conectarARutaPavimentada(){
		cumpleRutaPavimentada = true;
	}
	
	public abstract void desconectarDeRedDeAgua();
	
	public abstract void desconectarDeRedElectrica();
	
	public abstract void desconectarDeRutaPavimentada();
	
}