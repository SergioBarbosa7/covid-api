package br.com.sergio.api.covid.utils;

import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.service.PaisService;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import com.google.gson.reflect.TypeToken;
import jakarta.annotation.PostConstruct;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component(value = "paisLoader")
public class PaisLoader {
	
	private static final Logger LOG = LogManager.getLogger(PaisLoader.class);
	private ConversorDados conversorDados;
	private PaisService paisService;
	
	public PaisLoader(ConversorDados conversorDados, PaisService paisService) {
		this.conversorDados = conversorDados;
		this.paisService = paisService;
	}
	
	@PostConstruct
	public void iniciaPaises(){
		if(!paisService.paisesJaForamCarregados()){
			carregaPaises();
		}
	}
	
	public void carregaPaises() {
		String championJson = carregaJson();
		//Conversão do JSON do campeão para uma lista
		List<Pais> paises = conversorDados.converterDadosDoJson(championJson, new TypeToken<List<Pais>>(){}.getType());

		if (!paises.isEmpty()) {
			LOG.info("Foram encontrados {} paises, iniciando processamento", paises.size());
			paises.forEach(paisService::salvaPais);
		} else {
			LOG.warn("Nao foram encontrados nenhum campeao, favor verificar");
		}
	}
	
	private String carregaJson() {
		try {
			LOG.info("Carregando arquivo paises.json da resources");
			InputStream jsonInputStream = getClass().getClassLoader().getResourceAsStream("json/paises.json");
			if (jsonInputStream != null) {
				String json = IOUtils.toString(jsonInputStream, StandardCharsets.UTF_8);
				LOG.info("Json carregado:\n" + json);
				return json;
			}
		} catch (IOException ioe) {
			LOG.error("Erro ao carregar JSON");
			ioe.printStackTrace();
			throw new RuntimeException(ioe);
		}
		return null;
	}
	
}
