package algocity.core.capas.catastrofes;

import java.util.Random;

public class terremoto extends Catastrofe {
	int origenX;
	int origenY;
	float danioInicial;
	
	public terremoto() {
		Random rn = new Random();
		origenX = rn.nextInt(filas);
		origenY = rn.nextInt(columnas);
		danioInicial = Math.round((70*rn.nextFloat())*10)/10 + 30;
	}
}
