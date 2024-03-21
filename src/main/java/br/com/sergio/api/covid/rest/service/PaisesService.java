package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.external.service.ExternalDadosPaisesServices;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;

@Service
public class PaisesService {

	ExternalDadosPaisesServices externalPaisesServices;
	
	public PaisesService(ExternalDadosPaisesServices externalPaisesServices) {
		this.externalPaisesServices = externalPaisesServices;
	}
	
	public String obtemPaisesDaOrigem(String pais, String casos) throws URISyntaxException {
		return externalPaisesServices.obtemJsonDoEnvelope(pais, casos);
	}
	
	
	
}
