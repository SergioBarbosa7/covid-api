package br.com.sergio.api.covid.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@SerializedName("pais_portugues")
	@Column(name = "nome_pais_portugues")
	private String nomePortugues;
	
	@SerializedName("pais_sem_acentos")
	@Column(name = "nome_pais_sem_acentos")
	private String nomeSemAcentuacao;
	
	@SerializedName("pais_ingles")
	@Column(name = "nome_pais_ingles")
	private String nomeIngles;
	
	public String getNomePortugues() {
		return nomePortugues;
	}
	
	public void setNomePortugues(String nomePortugues) {
		this.nomePortugues = nomePortugues;
	}
	
	public String getNomeSemAcentuacao() {
		return nomeSemAcentuacao;
	}
	
	public void setNomeSemAcentuacao(String nomeSemAcentuacao) {
		this.nomeSemAcentuacao = nomeSemAcentuacao;
	}
	
	public String getNomeIngles() {
		return nomeIngles;
	}
	
	public void setNomeIngles(String noemIngles) {
		this.nomeIngles = noemIngles;
	}
	
}
