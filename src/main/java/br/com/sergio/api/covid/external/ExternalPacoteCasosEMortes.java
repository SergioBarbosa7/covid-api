package br.com.sergio.api.covid.external;

import java.time.LocalDate;
import java.util.Map;

public class ExternalPacoteCasosEMortes {
	private String pais;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private Map<String, ExternalDadosPorDia> dadosMortes;
	private Map<String, ExternalDadosPorDia> dadosCasos;
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Map<String, ExternalDadosPorDia> getDadosMortes() {
		return dadosMortes;
	}
	
	public void setDadosMortes(Map<String, ExternalDadosPorDia> dadosMortes) {
		this.dadosMortes = dadosMortes;
	}
	
	public Map<String, ExternalDadosPorDia> getDadosCasos() {
		return dadosCasos;
	}
	
	public void setDadosCasos(Map<String, ExternalDadosPorDia> dadosCasos) {
		this.dadosCasos = dadosCasos;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	
}
