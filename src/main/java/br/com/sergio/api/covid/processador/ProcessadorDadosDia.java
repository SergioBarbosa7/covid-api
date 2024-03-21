package br.com.sergio.api.covid.processador;


import br.com.sergio.api.covid.conversor.impl.ConversorMapDadosExternosToListDadosPorDia;
import br.com.sergio.api.covid.external.ExternalDadosPorDia;
import br.com.sergio.api.covid.model.DadosPorDia;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProcessadorDadosDia {

	ConversorMapDadosExternosToListDadosPorDia conversorDadosDias = new ConversorMapDadosExternosToListDadosPorDia();
	
	
	public List<DadosPorDia> converteDadosPorDia(Map<String, ExternalDadosPorDia> mapExterno) {
		return conversorDadosDias.converter(mapExterno);
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
	
	public Integer obtemPicoDeCasosPorDia(List<DadosPorDia> lista){
		return lista.stream()
				.min(Comparator.comparingInt(DadosPorDia::getNovos))
				.get()
				.getNovos();
	}
	
	public Integer obtemTotalNoPeriodo(List<DadosPorDia> lista){
		return obtemTotalFinal(lista) - obtemTotalInicial(lista);
	}
}
