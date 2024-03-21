package br.com.sergio.api.covid.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "benchmark_total")
public class BenchmarkTotal {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_benchmark")
	private String nomeBenchmark;
	
	@Column(name = "data_inicial")
	private Date dataInicial;
	
	@Column(name = "data_final")
	private Date dataFinal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_benchmark_pais_1")
	private BenchmarkPais benchmarkPais1;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_benchmark_pais_2")
	private BenchmarkPais benchmarkPais2;
	
	public String getNomeBenchmark() {
		return nomeBenchmark;
	}
	
	public void setNomeBenchmark(String nomeBenchmark) {
		this.nomeBenchmark = nomeBenchmark;
	}
	
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
	
	public BenchmarkPais getBenchmarkPais1() {
		return benchmarkPais1;
	}
	
	public void setBenchmarkPais1(BenchmarkPais benchmarkPais1) {
		this.benchmarkPais1 = benchmarkPais1;
	}
	
	public BenchmarkPais getBenchmarkPais2() {
		return benchmarkPais2;
	}
	
	public void setBenchmarkPais2(BenchmarkPais benchmarkPais2) {
		this.benchmarkPais2 = benchmarkPais2;
	}
	
}
