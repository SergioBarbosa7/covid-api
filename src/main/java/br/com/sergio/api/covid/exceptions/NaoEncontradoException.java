package br.com.sergio.api.covid.exceptions;

public class NaoEncontradoException extends RuntimeException {
	private final String objeto;
	private final String valor;
	
	public NaoEncontradoException(String objeto, String valor) {
		this.objeto = objeto;
		this.valor = valor;
	}
	
	public String getObjeto() {
		return objeto;
	}
	
	public String getValor() {
		return valor;
	}
	
}
