package br.com.sergio.api.covid.external;

import com.google.gson.annotations.SerializedName;

public class DadosPorDia {
	private Integer total;
	
	@SerializedName("new")
	private Integer novos;
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getNovos() {
		return novos;
	}
	
	public void setNovos(Integer novos) {
		this.novos = novos;
	}
	
	public void adicionaAoTotal(Integer total) {
		this.total += total;
	}
	
	public void adicionaAosNovos(Integer novos){
		this.novos += novos;
	}
	
}
