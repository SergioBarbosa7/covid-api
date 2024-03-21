package br.com.sergio.api.covid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class BenchmarkPais {
	
	@Id
	@Column
	private Long id;
	
	@Column(name = "nome_pais")
	private String nomePais;
	
	@Column(name = "data_inicial")
	private Date dataInicial;
	
	@Column(name = "data_final")
	private Date dataFinal;
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	private Integer casosNoPeriodo;
	private Integer mortesNoPeriodo;
	public String getNomePais() {
		return nomePais;
	}
	
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	
	public Integer getCasosNoPeriodo() {
		return casosNoPeriodo;
	}
	
	public void setCasosNoPeriodo(Integer casosNoPeriodo) {
		this.casosNoPeriodo = casosNoPeriodo;
	}
	
	public Integer getMortesNoPeriodo() {
		return mortesNoPeriodo;
	}
	
	public void setMortesNoPeriodo(Integer mortesNoPeriodo) {
		this.mortesNoPeriodo = mortesNoPeriodo;
	}
}
