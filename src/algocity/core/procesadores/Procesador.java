package algocity.core.procesadores;

import algocity.core.capas.Hectarea;

public interface Procesador {

	/**
	 * Interfaz implementada por las clases que pueden procesar
	 * hectareas.
	 * Por ejemplo, la pueden implementar clases capaces de procesar
	 * las hectareas en un turno.
	 */

	public void procesarHectarea(Hectarea hectarea);
	public void finalizarProceso();
}
