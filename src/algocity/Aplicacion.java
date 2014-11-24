package algocity;

import algocity.core.Juego;
import algocity.vistas.VistaDeMapa;
import algocity.vistas.VistaDePartida;

public class Aplicacion {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.print("Muy pocos argumentos!");
			return;
		}
		int filas = Integer.parseInt(args[0]);
		int columnas = Integer.parseInt(args[1]);
		Juego juego = new Juego();
		juego.prepararMapa(filas, columnas);
		//juego.comenzarPartida();
		VistaDePartida vistaDePartida = new VistaDePartida();
		VistaDeMapa vistaDeMapa = new VistaDeMapa(juego.getMapa());
		vistaDePartida.add(vistaDeMapa);
		vistaDePartida.setVisible(true);
	}

}
