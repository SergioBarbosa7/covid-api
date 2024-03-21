package br.com.sergio.api.covid.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "benchmark_pais")
public class BenchmarkPais {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_pais")
	private String nomePais;
	
	@Column(name = "data_inicial")
	private Date dataInicial;
	
	@Column(name = "data_final")
	private Date dataFinal;
	
	@OneToOne(mappedBy = "benchmarkPais", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
	private JsonsBenchmarkPais jsonsBenchmarkPais;
	
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
	
	
	public JsonsBenchmarkPais getJsonsBenchmarkPais() {
		return jsonsBenchmarkPais;
	}
	
	public void setJsonsBenchmarkPais(JsonsBenchmarkPais jsonsBenchmarkPais) {
		this.jsonsBenchmarkPais = jsonsBenchmarkPais;
	}
	
}
