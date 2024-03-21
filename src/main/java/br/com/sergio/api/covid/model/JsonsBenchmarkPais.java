package br.com.sergio.api.covid.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "benchmark_json")
public class JsonsBenchmarkPais {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "json_casos")
	private String jsonCasos;
	
	@Column(name = "json_mortes")
	private String jsonMortes;
	
	@OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_benchmark_pais")
	private BenchmarkPais benchmarkPais;
	
	public String getJsonCasos() {
		return jsonCasos;
	}
	
	public void setJsonCasos(String jsonCasos) {
		this.jsonCasos = jsonCasos;
	}
	
	public String getJsonMortes() {
		return jsonMortes;
	}
	
	public void setJsonMortes(String jsonMortes) {
		this.jsonMortes = jsonMortes;
	}
	
	public BenchmarkPais getBenchmarkPais() {
		return benchmarkPais;
	}
	
	public void setBenchmarkPais(BenchmarkPais benchmarkPais) {
		this.benchmarkPais = benchmarkPais;
	}
	
}
