package algocity.core.io;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import algocity.core.Mapa;
import algocity.core.Partida;
import algocity.core.capas.Hectarea;
import algocity.core.capas.tendido.RedDeAgua;
import algocity.core.capas.tendido.RedElectrica;
import algocity.core.capas.tendido.RutaPavimentada;
import algocity.core.capas.tendido.Tendido;

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

		RedDeAgua redDeAgua = partida.getMapa().getRedDeAgua();
		jsonObject.add("redDeAgua", context.serialize(redDeAgua));
		RedElectrica redElectrica = partida.getMapa().getRedElectrica();
		jsonObject.add("redElectrica", context.serialize(redElectrica));
		RutaPavimentada rutaPavimentada = partida.getMapa().getRutaPavimentada();
		jsonObject.add("rutaPavimentada", context.serialize(rutaPavimentada));

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

 		JsonObject redDeAguaJson = jsonObject.get("redDeAgua").getAsJsonObject();
 		RedDeAgua redDeAgua = context.deserialize(redDeAguaJson, RedDeAgua.class);
 		llenarNodos(redDeAgua, mapa, redDeAguaJson);
 		mapa.setRedDeAgua(redDeAgua);

 		JsonObject redElectricaJson = jsonObject.get("redElectricaJson").getAsJsonObject();
 		RedElectrica redElectrica = context.deserialize(
 				redElectricaJson, RedElectrica.class);
 		llenarNodos(redElectrica, mapa, redElectricaJson);
 		mapa.setRedElectrica(redElectrica);

 		JsonObject rutaPavimentadaJson = jsonObject.get("rutaPavimentadaJson").getAsJsonObject();
 		RutaPavimentada rutaPavimentada = context.deserialize(
 				rutaPavimentadaJson, RutaPavimentada.class);
 		llenarNodos(rutaPavimentada, mapa, rutaPavimentadaJson);
 		mapa.setRutaPavimentada(rutaPavimentada);

		return partida;
	}

	private void llenarNodos(Tendido tendido, Mapa mapa, JsonObject tendidoJson) {

		JsonArray nodosJson = tendidoJson.get("nodos").getAsJsonArray();
		for (JsonElement nodoElement : nodosJson) {
			JsonObject nodoJson = nodoElement.getAsJsonObject();
			Hectarea hectarea = mapa.getHectarea(nodoJson.get("x").getAsInt(),
					nodoJson.get("y").getAsInt());
			tendido.agregarNodo(hectarea);
		}
	}

}
