package algocity.core.construibles;

import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.vistas.VistaDeInfo;

public abstract class CentralElectrica extends ConstruibleEnLlano implements Arreglable, Refrescable {

	int radioDeAlimentacion;
	int capacidad;
	int potenciaMaxima;
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

	public boolean restarPotencia(int consumo) {
		if (potenciaDisponible - consumo < 0)
			return false;
		potenciaDisponible -= consumo;
		return true;
	}

	@Override
	public void daniar (float porcentajeDeDanio) {
		if ((porcentajeDeVida -=  porcentajeDeDanio) < 0) {
			porcentajeDeVida = 0;
		}
	}

	@Override
	public void reparar (float porcentajeDeReparo) {
		if ((porcentajeDeVida +=  porcentajeDeReparo) > 100) {
			porcentajeDeVida = 100;
		}
	}

	@Override
	public boolean cumpleRequerimientos(boolean conexionAgua,
			boolean conexionRuta, boolean conexionElectrica){
		return conexionAgua;
	}

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		if (!mapa.getHectarea(x, y).redDeAguaConectada())
			return;

		if(mapa.getRedElectrica().agregarEdificioProveedor(x, y)){
			mapa.getHectareasDeCentralElectrica().add(mapa.getHectarea(x,y));
			setHectareasCercanas(mapa, x, y, true);
		}
	}
	
	@Override
	public void procesarBorrado(Mapa mapa, int x, int y) {
		mapa.getRedElectrica().eliminarEdificioProveedor(x,y);
		mapa.getHectareasDeCentralElectrica().remove(mapa.getHectarea(x,y));
		setHectareasCercanas(mapa, x, y, false);
	}

	@Override
	public void procesarConexion(Mapa mapa, int x, int y) {
		procesarAgregado(mapa, x, y);
	}

	@Override
	public void procesarDesconexion(Mapa mapa, int x, int y) {
		if (mapa.getHectarea(x, y).redDeAguaConectada())
			return;
		procesarBorrado(mapa, x, y);
	}
	
	private void setHectareasCercanas(Mapa mapa, int x, int y, boolean b) {
		for(Iterator<Hectarea> iter =
				mapa.recorrerEnUnRadio(radioDeAlimentacion, x, y);
				iter.hasNext();) {
				Hectarea hectarea = iter.next();
				hectarea.setCentralesCerca(b);
			}
	}

	@Override
	public void teImpacta(Godzilla godzy) {
		godzy.impactarEn(this);
	}

	@Override
	public void mostrarInfo(VistaDeInfo vistaDeInfo) {
		vistaDeInfo.mostrarInfo(this);
	}

	@Override
	public void refresh() {
		potenciaDisponible = capacidad;
	}
}