package algocity.core.construibles;

import algocity.core.Configuracion;
import algocity.core.Mapa;
import algocity.core.capas.catastrofes.Godzilla;
import algocity.vistas.VistaDeInfo;
public class Residencial extends Edificio {

	int habitantes;

	public Residencial() {
		habitantes = 0;
		costo = 5;
		consumo = 1;
}

	public int habitantes() {
		return habitantes;
	}

	public int disponibilidad() {
		return Configuracion.MaximoHabitantes - habitantes;
	}

	public boolean agregarHabitantes (int habitantesNuevos) {
		if (habitantes + habitantesNuevos <= Configuracion.MaximoHabitantes)  {
			habitantes += habitantesNuevos;
			return true;
		}
		return false;
	}

	public boolean quitarHabitantes (int habitantesSalientes) {
		if ( (habitantes - habitantesSalientes) >= 0) {
			habitantes -= habitantesSalientes;
			return true;
		}
		return false;
	}

	@Override
	public void teArreglanLosBomberos(EstacionDeBombero estacion) {
		estacion.arreglar(this);
	}

	@Override
	public void procesarAgregado(Mapa mapa, int x, int y) {
		mapa.getHectareasResidenciales().add(mapa.getHectarea(x, y));
	}

	@Override
	public void procesarBorrado(Mapa mapa, int x, int y) {
			mapa.getHectareasResidenciales().remove(mapa.getHectarea(x, y));
	}

	@Override
	public void teImpacta(Godzilla godzy) {
		godzy.impactame(this);
	}

	public int trabajadores() {
		int familias = habitantes / 4;
		int otros = habitantes - (familias * 4);
		if (otros > 0)
			return familias + 1;
		return familias;
	}

	public float danio() {
		return 100 - porcentajeDeVida;
	}

	public void modificarCantidadDeHabitantes(int modificacion) {
		if (modificacion >= 0){
			agregarHabitantes(modificacion);
		}else{
			quitarHabitantes(modificacion);
		}
	}

	@Override
	public void mostrarInfo(VistaDeInfo vistaDeInfo) {
		vistaDeInfo.mostrarInfo(this);
	}

}