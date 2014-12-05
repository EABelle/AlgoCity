package algocity.core;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<String> partidas;

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void agregarJuego(String partida) {
		partidas.add(partida);
	}

	public void setPartidas(ArrayList<String> partidas) {
		this.partidas = partidas;
	}

	public String getNombre() {
		return nombre;
	}

}
