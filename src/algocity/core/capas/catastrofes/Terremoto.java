package algocity.core.capas.catastrofes;

import java.util.Random;

import algocity.core.Mapa;

public class Terremoto extends Catastrofe {
	int origenX;
	int origenY;
	float danio;
	
	public Terremoto() {
		Random rn = new Random();
		origenX = rn.nextInt(filas);
		origenY = rn.nextInt(columnas);
		danio = Math.round((70*rn.nextFloat())*10)/10 + 30;
	}

	@Override
	public void procesar(Mapa mapa) {
		Random rn = new Random();
		origenX = rn.nextInt(filas);
		origenY = rn.nextInt(columnas);
		danio = Math.round((70*rn.nextFloat())*10)/10 + 30;
		
		int i;
		int j;
		int radio = 0;
		
		while (danio > 0) {
			for (i = 0; i <= radio; i ++){
				for (j = 0; j <=radio; j ++){
					//mapa.impactarTerremoto(danio);
				}
			}
			danio -= 1.5;
		}
	}
}
