package algocity.core.construibles;

import algocity.core.Partida;

public class PozoDeAgua extends ConstruibleEnAgua {
	int costo;
	public PozoDeAgua(){
		costo = 250;
	}
	@Override
	public void desconectarDeRedDeAgua() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void desconectarDeRedElectrica() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void desconectarDeRutaPavimentada() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void procesarAgregado(Partida partida, int x, int y) {
		partida.agregarPozoDeAgua(x, y);
	}
}
