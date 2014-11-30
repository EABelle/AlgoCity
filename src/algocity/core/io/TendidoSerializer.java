package algocity.core.io;

import java.lang.reflect.Type;

import algocity.core.capas.tendido.Tendido;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TendidoSerializer implements JsonSerializer<Tendido> {

	@Override
	public JsonElement serialize(Tendido tendido, Type tipo,
			JsonSerializationContext context) {
		return null;
	}



}
