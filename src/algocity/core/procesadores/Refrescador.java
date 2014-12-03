package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.construibles.Construible;
import algocity.core.construibles.Refrescable;

public abstract class Refrescador {

	public static void refresh(Mapa mapa) {
		refresh(mapa.getHectareasIndustriales());
		refresh(mapa.getHectareasDeCentralElectrica());
		rearmar(mapa.getHectareasDaniadas());
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

}