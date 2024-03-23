package br.com.sergio.api.covid.rest.dto;

import java.util.Date;

public class BenchmarkPaisDTO {
	
	private String nomePais;
	private Integer diasNoPeriodo;
	private Double taxaDeMortalidade;
	private Date dataInicial;
	private Date dataFinal;
	private Integer casosIniciais;
	private Integer mortesIniciais;
	private Integer mortesNoPeriodo;
	private Integer casosNoPeriodo;
	private Integer picoDeMortes;
	private Integer picoDeCasos;
	private Date dataPicoDeCasos;
	private Date dataPicoDeMortes;
	private Integer mediaDeCasosPorDia;
	private Integer mediaDeMortesPorDia;
	
	public String getNomePais() {
		return nomePais;
	}
	
	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}
	
	public Double getTaxaDeMortalidade() {
		return taxaDeMortalidade;
	}
	
	public void setTaxaDeMortalidade(Double taxaDeMortalidade) {
		this.taxaDeMortalidade = taxaDeMortalidade;
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
	
	public Integer getCasosIniciais() {
		return casosIniciais;
	}
	
	public void setCasosIniciais(Integer casosIniciais) {
		this.casosIniciais = casosIniciais;
	}
	
	public Integer getMortesIniciais() {
		return mortesIniciais;
	}
	
	public void setMortesIniciais(Integer mortesIniciais) {
		this.mortesIniciais = mortesIniciais;
	}
	
	public Integer getMortesNoPeriodo() {
		return mortesNoPeriodo;
	}
	
	public void setMortesNoPeriodo(Integer mortesNoPeriodo) {
		this.mortesNoPeriodo = mortesNoPeriodo;
	}
	
	public Integer getCasosNoPeriodo() {
		return casosNoPeriodo;
	}
	
	public void setCasosNoPeriodo(Integer casosNoPeriodo) {
		this.casosNoPeriodo = casosNoPeriodo;
	}
	
	public Integer getPicoDeMortes() {
		return picoDeMortes;
	}
	
	public void setPicoDeMortes(Integer picoDeMortes) {
		this.picoDeMortes = picoDeMortes;
	}
	
	public Integer getPicoDeCasos() {
		return picoDeCasos;
	}
	
	public void setPicoDeCasos(Integer picoDeCasos) {
		this.picoDeCasos = picoDeCasos;
	}
	
	public Date getDataPicoDeCasos() {
		return dataPicoDeCasos;
	}
	
	public void setDataPicoDeCasos(Date dataPicoDeCasos) {
		this.dataPicoDeCasos = dataPicoDeCasos;
	}
	
	public Date getDataPicoDeMortes() {
		return dataPicoDeMortes;
	}
	
	public void setDataPicoDeMortes(Date dataPicoDeMortes) {
		this.dataPicoDeMortes = dataPicoDeMortes;
	}
	
	public Integer getMediaDeCasosPorDia() {
		return mediaDeCasosPorDia;
	}
	
	public void setMediaDeCasosPorDia(Integer mediaDeCasosPorDia) {
		this.mediaDeCasosPorDia = mediaDeCasosPorDia;
	}
	
	public Integer getMediaDeMortesPorDia() {
		return mediaDeMortesPorDia;
	}
	
	public void setMediaDeMortesPorDia(Integer mediaDeMortesPorDia) {
		this.mediaDeMortesPorDia = mediaDeMortesPorDia;
	}
	
	public Integer getDiasNoPeriodo() {
		return diasNoPeriodo;
	}
	
	public void setDiasNoPeriodo(Integer diasNoPeriodo) {
		this.diasNoPeriodo = diasNoPeriodo;
	}
	
}
