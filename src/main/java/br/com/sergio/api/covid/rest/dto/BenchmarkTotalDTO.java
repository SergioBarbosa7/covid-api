package br.com.sergio.api.covid.rest.dto;

import java.util.Date;

public class BenchmarkTotalDTO {
	
	private Long idBenchmark;
	private String nome;
	private String pais1;
	private String pais2;
	private Date dataInicial;
	private Date dataFinal;
	private BenchmarkPaisDTO benchmarkPais1;
	private BenchmarkPaisDTO benchmarkPais2;
	public Long getIdBenchmark() {
		return idBenchmark;
	}
	
	public void setIdBenchmark(Long idBenchmark) {
		this.idBenchmark = idBenchmark;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPais1() {
		return pais1;
	}
	
	public void setPais1(String pais1) {
		this.pais1 = pais1;
	}
	
	public String getPais2() {
		return pais2;
	}
	
	public void setPais2(String pais2) {
		this.pais2 = pais2;
	}
	
	public BenchmarkPaisDTO getBenchmarkPais1() {
		return benchmarkPais1;
	}
	
	public void setBenchmarkPais1(BenchmarkPaisDTO benchmarkPais1) {
		this.benchmarkPais1 = benchmarkPais1;
	}
	
	public BenchmarkPaisDTO getBenchmarkPais2() {
		return benchmarkPais2;
	}
	
	public void setBenchmarkPais2(BenchmarkPaisDTO benchmarkPais2) {
		this.benchmarkPais2 = benchmarkPais2;
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
	
}
