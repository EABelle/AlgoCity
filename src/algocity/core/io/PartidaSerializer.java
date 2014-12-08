package algocity.core.io;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.Partida;
import algocity.core.capas.Hectarea;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class PartidaSerializer implements JsonSerializer<Partida>,
	JsonDeserializer<Partida> {

	@Override
	public JsonElement serialize(Partida partida, Type type,
			JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("turno", partida.getTurno());
		jsonObject.addProperty("plata", partida.getPlata());
		jsonObject.addProperty("filas", partida.getMapa().getFilas());
		jsonObject.addProperty("columnas", partida.getMapa().getColumnas());

		JsonArray hectareas = new JsonArray();
		for (Iterator<Hectarea> iter = partida.getMapa().recorridoSecuencial();
				iter.hasNext();) {
			Hectarea hectarea = iter.next();
			JsonElement hectareaObj = context.serialize(hectarea);
			if (!hectareaObj.isJsonNull()) {
				hectareas.add(hectareaObj);
			}
		}
		jsonObject.add("hectareas", hectareas);
		return jsonObject;
	}

	@Override
	public Partida deserialize(JsonElement elem, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		Partida partida; int filas; int columnas;
		JsonObject jsonObject = elem.getAsJsonObject();

		filas = jsonObject.get("filas").getAsInt();
		columnas = jsonObject.get("columnas").getAsInt();
 		Mapa mapa = new Mapa(filas, columnas);
 		partida = new Partida(mapa);
 		partida.inicializar();
 		partida.setPlata(jsonObject.get("plata").getAsInt());
 		partida.setTurno(jsonObject.get("turno").getAsInt());

 		JsonArray hectareasJson = jsonObject.get("hectareas").getAsJsonArray();
 		Type listType = new TypeToken<ArrayList<Hectarea>>() {}.getType();
 		ArrayList<Hectarea> hectareas = context.deserialize(hectareasJson, listType);
 		mapa.llenar(hectareas);

		return partida;
	}

}
