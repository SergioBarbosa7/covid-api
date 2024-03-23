package br.com.sergio.api.covid.processador;


import br.com.sergio.api.covid.conversor.impl.ConversorMapDadosExternosToListDadosPorDia;
import br.com.sergio.api.covid.external.ExternalDadosPorDia;
import br.com.sergio.api.covid.model.DadosPorDia;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProcessadorDadosDia {

	private ConversorMapDadosExternosToListDadosPorDia conversorDadosDias = new ConversorMapDadosExternosToListDadosPorDia();
	
	private ConversorDados conversorJson;
	
	public ProcessadorDadosDia(ConversorDados conversorJson) {
		this.conversorJson = conversorJson;
	}
	
	public List<DadosPorDia> converteDadosPorDia(Map<String, ExternalDadosPorDia> mapExterno) {
		return conversorDadosDias.converter(mapExterno);
	}
	
	public List<DadosPorDia> obtemDadosPorDiaDoJson(String json) {
		return conversorJson.converterDadosDoJson(json, new TypeToken<List<DadosPorDia>>(){}.getType());
	}
	
	public Integer obtemTotalFinal(List<DadosPorDia> lista){
		return lista.stream()
				.max(Comparator.comparingInt(DadosPorDia::getTotal))
				.get()
				.getTotal();
				
	}
	
	public Integer obtemTotalInicial(List<DadosPorDia> lista){
		return lista.stream()
				.min(Comparator.comparingInt(DadosPorDia::getTotal))
				.get()
				.getTotal();
	}
	
	public List<DadosPorDia> filtraPorPeriodo(List<DadosPorDia> lista, LocalDate dataInicial, LocalDate dataFinal){
		List<DadosPorDia> listaFiltrada = lista.stream()
				.filter(d -> d.getData().isAfter(dataInicial))
				.filter(d -> d.getData().isBefore(dataFinal))
				.collect(Collectors.toList());
		
		return listaFiltrada;
	}
	
	public DadosPorDia obtemPicoPorDia(List<DadosPorDia> lista){
		return lista.stream()
				.max(Comparator.comparingInt(DadosPorDia::getNovos))
				.get();
	}
	
	public Integer obtemTotalNoPeriodo(List<DadosPorDia> lista){
		return obtemTotalFinal(lista) - obtemTotalInicial(lista);
	}
}
