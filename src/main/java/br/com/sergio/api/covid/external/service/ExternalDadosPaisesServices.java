package br.com.sergio.api.covid.external.service;

import static br.com.sergio.api.covid.utils.Constantes.CASOS;
import static br.com.sergio.api.covid.utils.Constantes.MORTES;

import br.com.sergio.api.covid.comunicacao.ConsumoApi;
import br.com.sergio.api.covid.external.ExternalEnvelopeDadosPorPais;
import br.com.sergio.api.covid.external.ExternalListaEnvelopesDadosPorPais;
import br.com.sergio.api.covid.external.ExternalPacoteCasosEMortes;
import br.com.sergio.api.covid.external.handler.ExternalDadosPaisesHandler;
import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.service.PaisService;
import br.com.sergio.api.covid.utils.ConstrutorDeURL;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import org.springframework.stereotype.Service;

@Service
public class ExternalDadosPaisesServices {
	
	private final ConversorDados conversorDados;
	private final ConsumoApi consumoApi;
	private final PaisService paisService;
	private final ConstrutorDeURL construtorDeURL;
	private final ExternalDadosPaisesHandler paisesHandler;
	
	
	public ExternalDadosPaisesServices(ConsumoApi consumoApi, PaisService paisService, ExternalDadosPaisesHandler paisesHandler,
									   ConstrutorDeURL construtorDeURL, ConversorDados conversorDados) {
		this.consumoApi = consumoApi;
		this.paisService = paisService;
		this.paisesHandler = paisesHandler;
		this.construtorDeURL = construtorDeURL;
		this.conversorDados = conversorDados;
	}
	
	
	public String obtemJsonDoEnvelope(String pais, String tipo) {
		ExternalEnvelopeDadosPorPais envelope = obtemEnvelopeDadosPais(pais, tipo);
		return conversorDados.converterDadosParaJson(envelope, ExternalEnvelopeDadosPorPais.class);
	}
	
	
	public ExternalEnvelopeDadosPorPais obtemEnvelopeDadosPais(String pais, String tipo) {
		String json = consumoApi.obterDados(construtorDeURL.constroiURL(pais, tipo));
		ExternalListaEnvelopesDadosPorPais listaEnvelopesDadosPorPais = conversorDados.converterDadosDoJson(json,
				ExternalListaEnvelopesDadosPorPais.class);
		return paisesHandler.trataPaisesComRegioes(listaEnvelopesDadosPorPais);
	}
	
	public ExternalPacoteCasosEMortes obtemPacoteCasosEMortes(String nomePais){
		Pais pais = paisService.obtemPaisPeloNome(nomePais);
		ExternalEnvelopeDadosPorPais envelopeCasos = obtemEnvelopeDadosPais(pais.getNomeIngles(), CASOS);
		ExternalEnvelopeDadosPorPais envelopeMortes = obtemEnvelopeDadosPais(pais.getNomeIngles(), MORTES);
		
		ExternalPacoteCasosEMortes pacote = new ExternalPacoteCasosEMortes();
		pacote.setDadosCasos(envelopeCasos.getMapDataParaDados());
		pacote.setDadosMortes(envelopeMortes.getMapDataParaDados());
		pacote.setPais(pais.getNomePortugues());
		return pacote;
	}
}
