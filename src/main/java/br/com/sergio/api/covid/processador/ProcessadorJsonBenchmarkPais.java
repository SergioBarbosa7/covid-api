package br.com.sergio.api.covid.processador;

import br.com.sergio.api.covid.model.DadosPorDia;
import br.com.sergio.api.covid.model.JsonsBenchmarkPais;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProcessadorJsonBenchmarkPais {
	private final ConversorDados conversorDados;
	private static final Logger LOG = LogManager.getLogger(ProcessadorJsonBenchmarkPais.class);
	public ProcessadorJsonBenchmarkPais(ConversorDados conversorDados) {
		this.conversorDados = conversorDados;
	}
	
	public JsonsBenchmarkPais converteDadosDiaParaJson(List<DadosPorDia> casosPorDia, List<DadosPorDia> mortesPorDia){
		LOG.info("Convertendo casos e mortes para armazenamento no banco");
		JsonsBenchmarkPais jsonsBenchmarkPais = new JsonsBenchmarkPais();
		jsonsBenchmarkPais.setJsonCasos(conversorDados.converterDadosParaJson(casosPorDia, new TypeToken<List<DadosPorDia>>(){}.getType()));
		jsonsBenchmarkPais.setJsonMortes(conversorDados.converterDadosParaJson(mortesPorDia, new TypeToken<List<DadosPorDia>>(){}.getType()));
		return jsonsBenchmarkPais;
	}
	
}
