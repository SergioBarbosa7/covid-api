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
				", mapDataParaDados=" + mapDataParaDados.toString() + '}';
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public Map<String, DadosPorDia> getMapDataParaDados() {
		return mapDataParaDados;
	}
	
	public void setMapDataParaDados(Map<String, DadosPorDia> mapDataParaDados) {
		this.mapDataParaDados = mapDataParaDados;
	}
	
}
