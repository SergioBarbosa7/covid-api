package br.com.sergio.api.covid.rest.dto;

import java.util.Date;

public class ResumoBenchmarkDTO
{
	private Long idBenchmark;
	private String nome;
	private String nomePais1;
	private String nomePais2;
	private Date dataInicial;
	private Date dataFinal;
	
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
	
	public String getNomePais1() {
		return nomePais1;
	}
	
	public void setNomePais1(String nomePais1) {
		this.nomePais1 = nomePais1;
	}
	
	public String getNomePais2() {
		return nomePais2;
	}
	
	public void setNomePais2(String nomePais2) {
		this.nomePais2 = nomePais2;
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
