package algocity.core;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<String> partidas;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.partidas = new ArrayList<String>();
	}

	public void agregarPartida(String partida) {
		if (!partidas.contains(partida))
			partidas.add(partida);
	}

	public void setPartidas(ArrayList<String> partidas) {
		this.partidas = partidas;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<String> getPartidas() {
		return partidas;
	}

}
