package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.catastrofes.Catastrofe;
import algocity.core.construibles.Construible;
import algocity.core.construibles.Refrescable;

public abstract class Refrescador {

	public static void refresh(Mapa mapa) {
		refresh(mapa.getHectareasIndustriales());
		refresh(mapa.getHectareasDeCentralElectrica());
		rearmar(mapa.getHectareasDaniadas());
		deshacerCatastrofes(mapa.recorridoSecuencial());
	}

	private static void deshacerCatastrofes(Iterator<Hectarea> iter) {
		while (iter.hasNext()) {
			Hectarea hectarea= iter.next();
			hectarea.setGodzillaPresente(false);
			hectarea.setTerremotoPresente(false);
		}
	}

	private static void rearmar(ArrayList<Hectarea> hectareas) {
		Iterator<Hectarea> iter = hectareas.iterator();
		ArrayList<Hectarea> noDaniados = new ArrayList<Hectarea>();
		while (iter.hasNext()) {
			Hectarea hectarea= iter.next();
			Construible daniado = hectarea.getConstruible();
			if (!daniado.daniado()) {
				noDaniados.add(hectarea);
			}
		}
		hectareas.removeAll(noDaniados);
	}

	private static void refresh(ArrayList<Hectarea> hectareas) {
		Iterator<Hectarea> iter = hectareas.iterator();
		while (iter.hasNext()) {
			Hectarea hectarea= iter.next();
			Refrescable refrescable = (Refrescable)hectarea.getConstruible();
			refrescable.refresh();
		}
	}

	public static void actualizarCatastrofes(ArrayList<Catastrofe> catastrofes) {
		ArrayList<Catastrofe> catastrofesFinalizadas = new ArrayList<Catastrofe>();
		for (Iterator<Catastrofe> iterator = catastrofes.iterator(); iterator.hasNext();) {
			Catastrofe catastrofe = iterator.next();
			if (!catastrofe.estaPresente()) {
				catastrofesFinalizadas.add(catastrofe);
			}
		}
		catastrofes.removeAll(catastrofesFinalizadas);
	}

}