package br.com.sergio.api.covid.comunicacao;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumoApi {
	
	@Value("${covid-api-key}")
	private String API_KEY;
	
	private static final Logger LOG = LogManager.getLogger(ConsumoApi.class);
	
	public String obterDados(String endereco) {
		LOG.info("Encaminhando request para a URL: " + endereco);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endereco))
				.setHeader("X-Api-Key", API_KEY)
				.build();
		
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		LOG.info("Foi obtido código {} para a request", response.statusCode());
		return response.body();
	}
	
}
