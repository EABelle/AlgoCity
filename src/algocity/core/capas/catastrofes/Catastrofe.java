package algocity.core.capas.catastrofes;

import java.util.Random;

import algocity.core.Mapa;
import algocity.core.capas.tendido.RedElectrica;

public abstract class Catastrofe {
	
	public boolean apareceCatastrofe () {
		Random rm = new Random();
		return (rm.nextBoolean() & rm.nextBoolean() &
				rm.nextBoolean() & rm.nextBoolean());
	}
	
	public abstract void procesar (Mapa mapa, RedElectrica red);
}
