package br.com.sergio.api.covid.conversor;

public interface IConversor<E, S> {
	
	public S converter(E entrada);
}
