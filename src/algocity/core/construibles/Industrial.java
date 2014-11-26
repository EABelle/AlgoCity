package algocity.core.construibles;

import algocity.core.Mapa;
import algocity.core.procesadores.ProcesadorDeAgregado;
import algocity.core.procesadores.ProcesadorDeIndustrial;

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
	
/*	@Override
	public ProcesadorDeAgregado getProcesador(Mapa mapa, int x, int y) {
		ProcesadorDeIndustrial procesador = new ProcesadorDeIndustrial(mapa, x, y);
		procesador.setIndustrial(this);
		return procesador;
	}*/
	
	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getHectareasIndustriales().add(mapa.getHectarea(x, y));
	}
	
}