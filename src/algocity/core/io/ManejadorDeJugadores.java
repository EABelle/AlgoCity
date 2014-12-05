package algocity.core.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import algocity.core.Jugador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ManejadorDeJugadores {

	private String rutaDeJugadores;
	private Gson gson;
	ArrayList<Jugador> jugadores;

	public ManejadorDeJugadores() {
		this.rutaDeJugadores = "";

	    this.gson = new GsonBuilder().create();
	}

	public void setRutaDeJugadores(String rutaDeJugadores) {
		this.rutaDeJugadores = rutaDeJugadores;
	}

	private void leerJugadores() {
		BufferedReader br;
		try {
			 br = new BufferedReader(
					new FileReader(this.rutaDeJugadores));
			 Type listType = new TypeToken<List<Jugador>>() {}.getType();
			 jugadores = gson.fromJson(br, listType);
		} catch (FileNotFoundException e) {
			jugadores = new ArrayList<Jugador>();
			guardarJugadores(jugadores);
		}
	}

	private boolean guardarJugadores(ArrayList<Jugador> jugadores) {
		String json = gson.toJson(jugadores);
		try {
			FileWriter writer = new FileWriter(rutaDeJugadores);
		    writer.write(json);
		    writer.close();
		} catch (IOException e) {
		   return false;
		}
		return true;
	}

	public ArrayList<Jugador> getJugadores() {
		leerJugadores();
		return jugadores;
	}

	public ArrayList<String> nombresDeJugadores() {
		ArrayList<String> nombres = new ArrayList<String>();
		for (Jugador jugador : getJugadores()) {
			nombres.add(jugador.getNombre());
		}
		return nombres;
	}

	public Jugador crearJugador(String nombre) {
		leerJugadores();
		Jugador jugador = new Jugador(nombre);
		jugadores.add(jugador);
		if (guardarJugadores(jugadores)) {
			return jugador;
		}
		return null;
	}

	public Jugador obtenerJugadorPorNombre(String nombre) {
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre() == nombre) return jugador;
		}
		return null;

	}

}
