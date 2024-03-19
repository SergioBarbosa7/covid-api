package br.com.sergio.api.covid.external;

import com.google.gson.annotations.SerializedName;
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
