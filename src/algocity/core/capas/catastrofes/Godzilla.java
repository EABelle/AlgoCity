package algocity.core.capas.catastrofes;

import java.util.Random;

import algocity.core.Mapa;
import algocity.core.capas.tendido.RedElectrica;

public class Godzilla extends Catastrofe {
	int origenX;
	int origenY;

	@Override
	public void procesar(Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		switch (rn.nextInt(6)){
		case 0: movimientoHorizontal(mapa, red);
			break;
		case 1: movimientoVertical(mapa, red);
			break;
		case 2: movimientoDiagonal1(mapa, red);
			break;
		case 3: movimientoDiagonal2(mapa, red);
			break;
		case 4: movimientoZigZag1(mapa, red);
			break;
		case 5: movimientoZigZag2(mapa, red);
			break;
		}
	}
	
	
	private void romper(Mapa mapa, RedElectrica red, int x, int y) {
		mapa.impactarEn(x, y, danioPara(mapa.EnXYhayUn(x,y)));
		red.eliminarNodo(x, y);
	}
	
	private float danioPara(String tipo) {
		if (tipo.compareTo("Residencial") == 0) {
			return 100;
		}else if (tipo.compareTo("Comercial") == 0){
			return 75;
		}else if (tipo.compareTo("Industrial") == 0){
			return 40;
		}else if (tipo.compareTo("CentralEolica") == 0){
			return 35;
		}else if (tipo.compareTo("CentralMineral") == 0){
			return 35;
		}else if (tipo.compareTo("CentralNuclear") == 0){
			return 35;
		}
		return 0;
	}


	private void movimientoHorizontal (Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		origenX = 0;
		origenY = rn.nextInt(mapa.getFilas());
		
		int i;
		for (i = 0; i < mapa.getColumnas(); i ++) {
			romper(mapa, red, origenX + i, origenY);
		}
	}

	
	private void movimientoVertical (Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getColumnas());
		origenY = 0;
		
		int i;
		for (i = 0; i < mapa.getFilas(); i ++) {
			romper(mapa, red, origenX, origenY + i);
		}
	}
	
	private void movimientoDiagonal1 (Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getColumnas());
		origenY = 0;
		
		int i = 0;
		while (((origenX + i) < mapa.getColumnas()) &&
				(origenY + i) < mapa.getFilas()) {
			romper(mapa, red, origenX + i, origenY + i);
			i ++;
		}
	}
	
	private void movimientoDiagonal2 (Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getColumnas());
		origenY = rn.nextInt(mapa.getFilas());
		
		int i = 0;
		while (((origenX + i) < mapa.getColumnas()) &&
				(origenY - i) >= 0) {
			romper(mapa, red, origenX + i, origenY - i);
			i ++;
		}
	}
	
	private void movimientoZigZag1 (Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		origenX = 0;
		origenY = rn.nextInt(mapa.getFilas());
		
		int i = 0;
		while (((origenX + i) < mapa.getColumnas()) &&
				(origenY - i) >= 0 && (origenY + i) < mapa.getFilas()) {
			romper(mapa, red, origenX + i, origenY - i);
			i ++;
			romper(mapa, red, origenX + i, origenY + i);
			i ++;
		}
	}
	
	private void movimientoZigZag2 (Mapa mapa, RedElectrica red) {
		Random rn = new Random();
		origenX = rn.nextInt(mapa.getColumnas());
		origenY = 0;
		
		int i = 0;
		while (((origenX + i) < mapa.getColumnas()) &&
				(origenY - i) >= 0 && (origenY + i) < mapa.getFilas()) {
			romper(mapa, red, origenX + i, origenY - i);
			i ++;
			romper(mapa, red, origenX + i, origenY + i);
			i ++;
		}
	}
	
}
