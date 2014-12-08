package algocity.core.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import algocity.core.Mapa;
import algocity.core.Partida;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.CentralEolica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GuardadorDePartida {

	private String ruta;
	private Gson gson;

	public GuardadorDePartida(String ruta) {
		this.ruta = ruta;
		prepararGson();
	}


	public boolean guardarPartida(Partida partida) {
	    String json = gson.toJson(partida);
		try {
			FileWriter writer = new FileWriter(ruta);
		    writer.write(json);
		    writer.close();
		} catch (IOException e) {
		   return false;
		}
		return true;
	}

	public Partida cargarPartida(String ruta) {
		Partida partida = null;
		BufferedReader br;
		try {
			 br = new BufferedReader(
					new FileReader(ruta));
			 partida = gson.fromJson(br, Partida.class);
		} catch (FileNotFoundException e) {
		}
		return partida;
	}

	private void prepararGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(Partida.class, new PartidaSerializer());
	    gsonBuilder.registerTypeAdapter(HectareaLlana.class, new HectareaSerializer());
	    gsonBuilder.registerTypeAdapter(HectareaAgua.class, new HectareaSerializer());
	    gsonBuilder.setPrettyPrinting();
	    gson = gsonBuilder.create();
	}

	public static void main(String[] args) {
		Mapa mapa = new Mapa(2, 2);
		mapa.llenar();
		Partida partida = new Partida(mapa);
		partida.inicializar();
		partida.pasarTurno();
		partida.agregarConstruible(new CentralEolica(), 0, 0);
//		guardarPartida(partida);
	}

}
