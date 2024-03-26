package br.com.sergio.api.covid.rest.requerst;

import io.swagger.v3.oas.annotations.media.Schema;

public class BenchmarkRequest {
	
	@Schema(example = "benchmark1")
	private String nome;
	@Schema(example = "brasil")
	private String nomePais1;
	@Schema(example = "argentina")
	private String nomePais2;
	@Schema(example = "2024-03-24", pattern = "yyyy-MM-dd")
	private String dataInicial;
	@Schema(example = "2024-03-25", pattern = "yyyy-MM-dd")
	private String dataFinal;
	
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
	
	public String getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public String getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
}
