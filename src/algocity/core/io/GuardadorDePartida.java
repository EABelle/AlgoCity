package algocity.core.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GuardadorDePartida {

	private Gson gson;

	public GuardadorDePartida() {
		prepararGson();
	}


	public boolean guardarPartida(Partida partida, String ruta) {
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
	    gsonBuilder.registerTypeAdapter(Hectarea.class, new HectareaSerializer());
	    gsonBuilder.registerTypeAdapter(HectareaLlana.class, new HectareaSerializer());
	    gsonBuilder.registerTypeAdapter(HectareaAgua.class, new HectareaSerializer());
	    gson = gsonBuilder.create();
	}

}
