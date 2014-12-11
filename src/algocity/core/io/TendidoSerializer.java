package algocity.core.io;

import java.lang.reflect.Type;
import java.util.ArrayList;

import algocity.core.capas.NodoTendido;
import algocity.core.capas.tendido.Coordenada;
import algocity.core.capas.tendido.Tendido;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TendidoSerializer implements JsonSerializer<Tendido>, JsonDeserializer<Tendido>{

	@Override
	public JsonElement serialize(Tendido tendido, Type tipo,
			JsonSerializationContext context) {
		JsonObject tendidoJson = new JsonObject();

		JsonArray nodosJson = new JsonArray();
		ArrayList<NodoTendido> nodos = tendido.getNodos();
		for (NodoTendido nodoTendido : nodos) {
			JsonObject nodoJson = new JsonObject();
			nodoJson.addProperty("x", nodoTendido.getX());
			nodoJson.addProperty("y", nodoTendido.getY());
			nodosJson.add(nodoJson);
		}
		tendidoJson.add("nodos", nodosJson);

		JsonArray proveedoresJson = new JsonArray();
		ArrayList<Coordenada> edificios = tendido.getEdificiosProveedores();
		for (Coordenada coordenada : edificios) {
			JsonObject nodoJson = new JsonObject();
			nodoJson.addProperty("x", coordenada.getX());
			nodoJson.addProperty("y", coordenada.getY());
			proveedoresJson.add(nodoJson);
		}
		tendidoJson.add("proveedores", proveedoresJson);

		return tendidoJson;
	}

	@Override
	public Tendido deserialize(JsonElement elem, Type tipo,
			JsonDeserializationContext context) throws JsonParseException {
		Tendido tendido = null;
		try {
			tendido = (Tendido) ((Class<?>) tipo).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e);
		}
		JsonObject tendidoJson = elem.getAsJsonObject();
		JsonArray nodosJson = tendidoJson.get("proveedores").getAsJsonArray();
		for (JsonElement nodoElement : nodosJson) {
			JsonObject nodoJson = nodoElement.getAsJsonObject();
			tendido.agregarEdificioProveedor(nodoJson.get("x").getAsInt(),
					nodoJson.get("y").getAsInt());
		}

		return tendido;
	}



}
