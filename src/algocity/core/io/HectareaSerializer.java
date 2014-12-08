package algocity.core.io;

import java.lang.reflect.Type;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaAgua;
import algocity.core.capas.HectareaLlana;
import algocity.core.construibles.Construible;
import algocity.core.construibles.Residencial;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class HectareaSerializer implements JsonSerializer<Hectarea>, JsonDeserializer<Hectarea> {

	@Override
	public JsonElement serialize(Hectarea hectarea, Type type,
			JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		Construible cons = hectarea.getConstruible();
		String tipo = "llana";
		if (hectarea instanceof HectareaAgua) {
			tipo = "agua";
		} else if (cons == null) {
			return null;
		}
		jsonObject.addProperty("x", hectarea.getFila());
		jsonObject.addProperty("y", hectarea.getColumna());
		jsonObject.addProperty("tipo", tipo);

		if (cons != null) {
			jsonObject.addProperty("construible", cons.getClass().getName());
			jsonObject.addProperty("vida", cons.getPorcetajeDeVida());
			if (cons instanceof Residencial) {
				jsonObject.addProperty("habitantes", ((Residencial) cons).habitantes());
			}
		}
		return jsonObject;
	}

	@Override
	public Hectarea deserialize(JsonElement elem, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject = elem.getAsJsonObject();
		Hectarea hectarea;

		if (jsonObject.get("tipo").getAsString().equals("agua")) {
			hectarea = new HectareaAgua();
		} else {
			hectarea = new HectareaLlana();
		}
		hectarea.setFila(jsonObject.get("x").getAsInt());
		hectarea.setColumna(jsonObject.get("y").getAsInt());

		JsonElement construibleJson = jsonObject.get("construible");
		if (construibleJson != null) {
			Class<?> clazz = null;
			try {
				clazz = Class.forName(construibleJson.getAsString());
				Construible cons = (Construible) clazz.newInstance();
				if (cons instanceof Residencial) {
					((Residencial) cons).agregarHabitantes(
							jsonObject.get("habitantes").getAsInt());
				}
				hectarea.agregarConstruible(cons);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			}
		}
		return hectarea;
	}

}
