package br.com.sergio.api.covid.processador;


import br.com.sergio.api.covid.conversor.impl.ConversorMapDadosExternosToListDadosPorDia;
import br.com.sergio.api.covid.external.ExternalDadosPorDia;
import br.com.sergio.api.covid.model.DadosPorDia;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProcessadorDadosDia {
	
	private static final Logger LOG = LogManager.getLogger(ProcessadorDadosDia.class);
	private final ConversorMapDadosExternosToListDadosPorDia conversorDadosDias =
			new ConversorMapDadosExternosToListDadosPorDia();
	private final ConversorDados conversorJson;
	
	public ProcessadorDadosDia(ConversorDados conversorJson) {
		this.conversorJson = conversorJson;
	}
	
	public List<DadosPorDia> converteDadosPorDia(Map<String, ExternalDadosPorDia> mapExterno) {
		return conversorDadosDias.converter(mapExterno);
	}
	
	public List<DadosPorDia> obtemDadosPorDiaDoJson(String json) {
		LOG.info("Convertendo json para lista de Dados por dia");
		List<DadosPorDia> lista = conversorJson.converterDadosDoJson(json, new TypeToken<List<DadosPorDia>>() {
		}.getType());
		LOG.info("Foram encontrados {} elementos no json", lista.size());
		return lista;
	}
	
	public Integer obtemTotalFinal(List<DadosPorDia> lista) {
		Integer max = lista.stream().max(Comparator.comparingInt(DadosPorDia::getTotal)).get().getTotal();
		LOG.info("Encontrado o maximo de {} para a lista de DadosPorDia", max);
		return max;
	}
	
	public Integer obtemTotalInicial(List<DadosPorDia> lista) {
		Integer min = lista.stream().min(Comparator.comparingInt(DadosPorDia::getTotal)).get().getTotal();
		LOG.info("Encontrado o total inicial de {} para a lista de DadosPorDia", min);
		return min;
	}
	
	public List<DadosPorDia> filtraPorPeriodo(List<DadosPorDia> lista, LocalDate dataInicial, LocalDate dataFinal) {
		List<DadosPorDia> listaFiltrada = lista.stream().filter(d -> d.getData().isAfter(dataInicial))
				.filter(d -> d.getData().isBefore(dataFinal)).collect(Collectors.toList());
		LOG.info("Lista foi filtrada para as datas {} até {}, foram encontrados {} elementos", dataInicial, dataFinal,
				listaFiltrada.size());
		return listaFiltrada;
	}
	
	public DadosPorDia obtemPicoPorDia(List<DadosPorDia> lista) {
		DadosPorDia dadosPorDia =  lista.stream().max(Comparator.comparingInt(DadosPorDia::getNovos)).get();
		LOG.info("Foi encontrado um pico de {} para a data {}", dadosPorDia.getNovos(), dadosPorDia.getData());
		return dadosPorDia;
	}
	
	public Integer obtemTotalNoPeriodo(List<DadosPorDia> lista) {
		Integer total = obtemTotalFinal(lista) - obtemTotalInicial(lista);
		LOG.info("Foi encontrado um total de {} casos no periodo", total);
		return total;
	}
	
}
