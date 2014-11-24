package algocity.core.construibles;


public class Industrial extends Edificio {
	
	int puestosDisponibles;
	
	public Industrial() {
		costo = 10;
		consumo = 5;
		puestosDisponibles = 25;
	}

	public boolean cumpleRequerimientos(boolean conexionAgua, 
			boolean conexionRuta, boolean conexionElectrica){
		return conexionRuta & conexionElectrica;
	}	
	
	public boolean agregarTrabajadores(int cantidad) {
		if ((puestosDisponibles - cantidad) >= 0){
			puestosDisponibles -= cantidad;
			return true;
		}
		return false;
	}
/*	
	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		redElectricaConectada = partida.redElectricaConectada(x, y);
	}
	
	public void procesarTurno(Partida partida, int x, int y) {
		redElectricaConectada = partida.redElectricaConectada(x, y);
		rutaPavimentadaConectada = partida.rutaPavimentadaConectada(x, y);
		if (daniado())
			partida.agregarDaniado(this, x, y);
	}
*/	
	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}
	
}