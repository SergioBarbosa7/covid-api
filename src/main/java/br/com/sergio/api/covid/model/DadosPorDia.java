package br.com.sergio.api.covid.model;

import java.time.LocalDate;


public class DadosPorDia {
	
	private LocalDate data;
	private Integer total;
	private Integer novos;
	
	public DadosPorDia() {
	}
	
	public DadosPorDia(String data, Integer total, Integer novos) {
		this.data = LocalDate.parse(data);
		this.total = total;
		this.novos = novos;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
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
	
}
