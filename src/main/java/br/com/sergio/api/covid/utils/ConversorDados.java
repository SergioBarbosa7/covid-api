package br.com.sergio.api.covid.utils;

import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class ConversorDados {
	
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public <T> T converterDadosDoJson(String json, Class<T> classe) {
		System.out.println("Convertendo json para a classe: " + classe);
		return gson.fromJson(json, classe);
	}
	
	public <T> T converterDadosDoJson(String json, Type tipo) {
		System.out.println("Convertendo json para o tipo" + tipo);
		return gson.fromJson(json, tipo);
	}
	
	public <T> String converterDadosParaJson(Object object, Class<T> classe) {
		System.out.println("Convertendo objeto da classe " + classe + " para json");
		return gson.toJson(object, classe);
	}
	
	public String converterDadosParaJson(Object object, Type tipo) {
		System.out.println("Convertendo objeto do tipo " + tipo + " para json");
		return gson.toJson(object, tipo);
	}
	
}