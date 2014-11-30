package algocity.controladores;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import algocity.vistas.VistaDeMapa;

public class ControladorDeMapa extends KeyAdapter {

	private VistaDeMapa vistaDeMapa;

	public ControladorDeMapa(VistaDeMapa vistaDeMapa) {
		this.vistaDeMapa = vistaDeMapa;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) {
	        case KeyEvent.VK_UP:
	        	vistaDeMapa.moverMapa(-1, 0);
	            break;
	        case KeyEvent.VK_DOWN:
	        	vistaDeMapa.moverMapa(1, 0);
	            break;
	        case KeyEvent.VK_LEFT:
	        	vistaDeMapa.moverMapa(0, -1);
	            break;
	        case KeyEvent.VK_RIGHT :
	        	vistaDeMapa.moverMapa(0, 1);
	            break;
	     }

	}

}
