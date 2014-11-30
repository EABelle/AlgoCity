package algocity.core.io;

import java.lang.reflect.Type;

import algocity.core.capas.Hectarea;
import algocity.core.capas.HectareaAgua;
import algocity.core.construibles.Construible;
import algocity.core.construibles.Residencial;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class HectareaSerializer implements JsonSerializer<Hectarea> {

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

}
