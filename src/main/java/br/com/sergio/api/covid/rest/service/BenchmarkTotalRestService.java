package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.model.BenchmarkTotal;
import br.com.sergio.api.covid.service.BenchmarkTotalService;
import br.com.sergio.api.covid.utils.ConversorDados;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BenchmarkTotalRestService {
	
	BenchmarkTotalService benchmarkTotalService;
	ConversorDados conversorDados;
	
	public BenchmarkTotalRestService(BenchmarkTotalService benchmarkTotalService, ConversorDados conversorDados) {
		this.benchmarkTotalService = benchmarkTotalService;
		this.conversorDados = conversorDados;
	}
	
	public String criaBenchmarkTotal(String nome, String pais1, String pais2, String dataInicial, String dataFinal) {
		return conversorDados.converterDadosParaJson(
				benchmarkTotalService.criaBenchmarkTotal(nome, pais1, pais2, dataInicial, dataFinal),
				BenchmarkTotal.class);
	}
	
	public String obtemBenchmarkTotalPeloId(Long id){
		BenchmarkTotal benchmarkTotal = benchmarkTotalService.obtemOptionalBenchmarkTotalPeloId(id);
		if(benchmarkTotal != null){
			return conversorDados.converterDadosParaJson(benchmarkTotal, BenchmarkTotal.class);
		}
		
		return "404 - Não encontrado";
	}
	
}
