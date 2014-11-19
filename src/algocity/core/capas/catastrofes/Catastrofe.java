package algocity.core.capas.catastrofes;

import algocity.core.Mapa;

public abstract class Catastrofe {
	int filas;
	int columnas;
	
	public abstract void procesar (Mapa mapa);
}
