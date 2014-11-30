package algocity;

import algocity.controladores.ControladorJuego;
import algocity.core.Juego;
import algocity.vistas.VentanaPrincipal;


public class Aplicacion {

	public static void main(String[] args) {
		Juego juego = new Juego();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ControladorJuego controlador = new ControladorJuego(juego, ventanaPrincipal);
		controlador.inicializar();
	}

}
