package algocity.core.capas.catastrofes;

import java.util.Random;

import algocity.core.Mapa;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.construibles.Construible;

public class Terremoto extends Catastrofe {
	int origenX;
	int origenY;
	float danio;
	

	public Terremoto(int x, int y) {
		origenX = x;
		origenY = y;
		danio = 50;
	}
	
	public Terremoto(Mapa mapa) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getFilas());
		origenY = rn.nextInt(mapa.getColumnas());
		
	}

	@Override
	public void procesar(Mapa mapa) {
		int radio = 1;
		
		Hectarea hectarea = mapa.getHectarea(origenX, origenY);
		Construible impactado = hectarea.getConstruible();
		
		if (impactado.daniar(danio)){
			
		}
		
		while (danio > 0);
			mapa.RecorrerSoloEnUnRadio(radio, origenX, origenY);
	}
	
}


/*	@Override
	public void procesar(Mapa mapa, RedElectrica red) {
		danio = 50;//Math.round((70*rn.nextFloat())*10)/10 + 30;
		
		int i;
		int radio = 0;
		
		mapa.impactarEn(origenX, origenY, danio);
		while (danio > 0) {
			radio ++;
			danio -= 1.5;
			for (i = 0; i <= radio; i ++){
				if ((origenX + i) < mapa.getFilas()){
					if ((origenY - radio) >= 0)
						mapa.impactarEn(origenX + i, origenY - radio, danio);
					if ((origenY + radio) < mapa.getColumnas())
						mapa.impactarEn(origenX + i, origenY + radio , danio);
				}else break;
			}
			for (i = 1; i < radio; i ++){
				if ((origenY + i) < mapa.getFilas()){
					if ((origenX - radio) >= 0)
						mapa.impactarEn(origenX  - radio, origenY + i , danio);
					if ((origenX + radio) < mapa.getColumnas())
						mapa.impactarEn(origenX + radio, origenY + i , danio);
				} else break;
			}
		}
	}
}
*/