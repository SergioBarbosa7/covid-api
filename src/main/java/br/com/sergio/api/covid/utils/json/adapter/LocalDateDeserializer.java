package br.com.sergio.api.covid.utils.json.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
	@Override
	public LocalDate deserialize(JsonElement jsonElement, Type type,
								 JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
		return LocalDate.parse(jsonElement.getAsString());
	}
	
}
