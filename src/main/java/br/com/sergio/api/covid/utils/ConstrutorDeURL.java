package br.com.sergio.api.covid.utils;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriBuilder;
import java.net.URISyntaxException;


@Component
public class ConstrutorDeURL {
	
	private static final String URL_BASE = "api.api-ninjas.com";
	
	private static final String ENDPOINT = "/v1/covid19";
	
	
	public String constroiURL(String pais,  String tipo) throws URISyntaxException {
		String link = new URIBuilder()
				.setScheme("https")
				.setHost(URL_BASE)
				.setPath(ENDPOINT)
				.addParameter("country", pais)
				.addParameter("type", tipo)
				.build().toString();
		
		
		return link;
	}
}
