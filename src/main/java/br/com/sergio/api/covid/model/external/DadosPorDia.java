package br.com.sergio.api.covid.model.external;

import com.google.gson.annotations.SerializedName;

public class DadosPorDia {
	private Integer total;
	
	@SerializedName("new")
	private Integer novos;
}
