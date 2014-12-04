package algocity.core.procesadores;

import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.capas.catastrofes.Catastrofe;

public class ProcesadorDeCatastrofes {

	public static void procesar(Mapa mapa, ArrayList<Catastrofe> catastrofes) {
		Iterator<Catastrofe> iter = catastrofes.iterator();
		Catastrofe catastrofe;
		while(iter.hasNext()) {
			catastrofe = iter.next();
			catastrofe.procesar(mapa);
		}
	}

}
