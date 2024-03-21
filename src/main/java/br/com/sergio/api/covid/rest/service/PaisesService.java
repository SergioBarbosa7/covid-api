package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.external.service.ExternalDadosPaisesServices;
import org.springframework.stereotype.Service;

@Service
public class PaisesService {

	ExternalDadosPaisesServices externalPaisesServices;
	
	public PaisesService(ExternalDadosPaisesServices externalPaisesServices) {
		this.externalPaisesServices = externalPaisesServices;
	}
	
	public String obtemPaisesDaOrigem(String pais, String tipo) {
		return externalPaisesServices.obtemJsonDoEnvelope(pais, tipo);
	}
	
	
	
}
