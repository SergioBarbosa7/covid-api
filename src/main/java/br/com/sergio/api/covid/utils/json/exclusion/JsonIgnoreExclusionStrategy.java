package br.com.sergio.api.covid.utils.json.exclusion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class JsonIgnoreExclusionStrategy implements ExclusionStrategy {
	
	@Override
	public boolean shouldSkipField(FieldAttributes campo) {
		return campo.getAnnotation(JsonIgnore.class) != null;
	}
	
	@Override
	public boolean shouldSkipClass(Class<?> classe) {
		return classe.getAnnotation(JsonIgnore.class) != null;
	}
	
}
