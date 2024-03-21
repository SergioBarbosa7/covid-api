package br.com.sergio.api.covid.model;

import java.time.LocalDate;


public class DadosPorDia {
	
	LocalDate data;
	Integer total;
	Integer novos;
	
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
