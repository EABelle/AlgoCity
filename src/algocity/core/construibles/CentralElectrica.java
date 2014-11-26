package algocity.core.construibles;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.procesadores.ProcesadorDeAgregado;
import algocity.core.procesadores.ProcesadorDeCentral;


public abstract class CentralElectrica extends ConstruibleEnLlano implements Arreglable{

	int radioDeAlimentacion;
	int capacidad;
	int potenciaDisponible;


	public int getRadioDeAlimentacion() {
		return radioDeAlimentacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getPotenciaDisponible() {
		return potenciaDisponible;
	}
	
	public boolean cumpleRequerimientos(boolean conexionAgua, 
			boolean conexionRuta, boolean conexionElectrica){
		return conexionAgua;
	}	

/*
	@Override
	public void procesarAgregado(Partida partida, int x, int y)  {

		int i;
		int j;

		partida.agregarCentralElectrica(x, y);

		for(i = 0; i <= 2 * radioDeAlimentacion; i++) {
			for (j = 0; j <= 2 * radioDeAlimentacion; j++) {
				if(((x - radioDeAlimentacion + i) >= 0 ) &&
					((x - radioDeAlimentacion + i) < partida.getfilas()) && ((y - radioDeAlimentacion + j) >= 0) && ((y - radioDeAlimentacion + j) <partida.getcolumnas()))
					partida.conectarRedElectrica(x - radioDeAlimentacion + i, y - radioDeAlimentacion + j);
			}
		}
	}

	@Override
	public void procesarTurno(Partida partida, int x, int y) {
		redDeAguaConectada = partida.redDeAguaConectada(x, y);
		if (daniado())
			partida.agregarDaniado(this, x, y);
	}
*/
	public boolean restarPotencia(int consumo) {
		if (potenciaDisponible - consumo < 0)
			return false;
		potenciaDisponible -= consumo;
		return true;

	}
	
/*	@Override
	public ProcesadorDeAgregado getProcesador(Mapa mapa, int x, int y) {
		ProcesadorDeCentral procesador = new ProcesadorDeCentral(mapa, x, y);
		procesador.setCentral(this);
		return procesador;
	}*/

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {

		mapa.getHectareasDeCentralElectrica().add(mapa.getHectarea(x,y));
		for(Iterator<Hectarea> iter = 
			mapa.recorrerEnUnRadio(radioDeAlimentacion, x, y);
			iter.hasNext();){
			Hectarea hectarea = iter.next();
			hectarea.conectarRedElectrica();
		}
	}

}