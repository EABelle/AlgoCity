package algocity.core.io;

import java.lang.reflect.Type;
import java.util.Iterator;

import algocity.core.Partida;
import algocity.core.capas.Hectarea;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class PartidaSerializer implements JsonSerializer<Partida> {

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

}
