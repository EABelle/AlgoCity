package algocity;

import algocity.core.Juego;

public class Main {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.print("Muy pocos argumentos!");
			return;
		}
		int filas = Integer.parseInt(args[0]);
		int columnas = Integer.parseInt(args[1]);
		Juego juego = new Juego();
		juego.prepararMapa(filas, columnas);
		juego.comenzarPartida();
		
	}
	
}
