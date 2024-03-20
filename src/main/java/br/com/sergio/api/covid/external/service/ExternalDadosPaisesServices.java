package br.com.sergio.api.covid.external.service;

import br.com.sergio.api.covid.comunicacao.ConsumoApi;
import br.com.sergio.api.covid.external.EnvelopeDadosPorPaisJson;
import br.com.sergio.api.covid.external.ListaEnvelopesDadosPorPaisJson;
import br.com.sergio.api.covid.external.handler.ExternalDadosPaisesHandler;
import br.com.sergio.api.covid.utils.ConstrutorDeURL;
import br.com.sergio.api.covid.utils.ConversorDados;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;

@Service
public class ExternalDadosPaisesServices {
	
	private final ConversorDados conversorDados;
	private final ConsumoApi consumoApi;
	private final ConstrutorDeURL construtorDeURL;
	private final ExternalDadosPaisesHandler paisesHandler;
	
	
	public ExternalDadosPaisesServices(ConsumoApi consumoApi, ExternalDadosPaisesHandler paisesHandler, ConstrutorDeURL construtorDeURL, ConversorDados conversorDados) {
		this.consumoApi = consumoApi;
		this.paisesHandler = paisesHandler;
		this.construtorDeURL = construtorDeURL;
		this.conversorDados = conversorDados;
	}
	
	
	public String obtemJsonDoEnvelope(String pais, String tipo) throws URISyntaxException {
		EnvelopeDadosPorPaisJson envelope = obtemEnvelopeDadosPais(pais, tipo);
		return conversorDados.converterDadosParaJson(envelope, EnvelopeDadosPorPaisJson.class);
	}
	
	
	public EnvelopeDadosPorPaisJson obtemEnvelopeDadosPais(String pais, String tipo) throws URISyntaxException {
		String json = consumoApi.obterDados(construtorDeURL.constroiURL(pais, tipo));
		ListaEnvelopesDadosPorPaisJson listaEnvelopesDadosPorPais = conversorDados.converterDadosDoJson(json,
				ListaEnvelopesDadosPorPaisJson.class);
		return paisesHandler.trataPaisesComRegioes(listaEnvelopesDadosPorPais);
	}
}
