package br.com.sergio.api.covid.model.external;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.time.LocalDate;
import java.util.Map;

public class EnvelopeDadosPorPais {
	
	private String pais;
	private String region;
	
	@SerializedName(value = "cases", alternate = "deaths")
	private Map<String, DadosPorDia> mapDataParaDados;
	
	@Override
	public String toString() {
		return "EnvelopeDadosPorPais{" + "pais='" + pais + '\'' + ", region='" + region + '\'' +
				", mapDataParaDados=" + mapDataParaDados + '}';
	}
	
}
