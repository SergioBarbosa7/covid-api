package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.comunicacao.ConsumoApi;
import br.com.sergio.api.covid.external.ListaEnvelopesDadosPorPais;
import br.com.sergio.api.covid.utils.ConstrutorDeURL;
import br.com.sergio.api.covid.utils.ConversorDados;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;

@Service
public class PaisesService {
	
	private final ConversorDados conversorDados;
	private final ConsumoApi consumoApi;
	private final ConstrutorDeURL construtorDeURL;
	
	
	
	public PaisesService(ConsumoApi consumoApi, ConstrutorDeURL construtorDeURL, ConversorDados conversorDados) {
		this.consumoApi = consumoApi;
		this.construtorDeURL = construtorDeURL;
		this.conversorDados = conversorDados;
	}
	
	public String obtemPaisesDaOrigem(String pais, String tipo) throws URISyntaxException {
		String json = consumoApi.obterDados(construtorDeURL.constroiURL(pais, "deaths"));
		ListaEnvelopesDadosPorPais envelopeDadosPorPais = conversorDados.converterDadosDoJson(json, ListaEnvelopesDadosPorPais.class);
		return envelopeDadosPorPais.toString();
	}
}
