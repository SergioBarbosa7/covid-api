package br.com.sergio.api.covid.service;

import br.com.sergio.api.covid.external.ExternalPacoteCasosEMortes;
import br.com.sergio.api.covid.external.service.ExternalDadosPaisesServices;
import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.processador.ProcessadorBenchmarkPais;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BenchmarkPaisService {
	
	private final ProcessadorBenchmarkPais processadorBenchmarkPais;
	private final ExternalDadosPaisesServices externalPaisesServices;
	private final ConversorDados conversorDados;
	private static final Logger LOG = LogManager.getLogger(BenchmarkPaisService.class);
	
	public BenchmarkPaisService(ProcessadorBenchmarkPais processadorBenchmarkPais,
								ExternalDadosPaisesServices externalPaisesServices, ConversorDados conversorDados) {
		this.processadorBenchmarkPais = processadorBenchmarkPais;
		this.externalPaisesServices = externalPaisesServices;
		this.conversorDados = conversorDados;
	}
	
	
	public String obtemJsonBenchmarkPais(String pais, String stringDataInicial, String stringDataFinal) {
		BenchmarkPais benchmarkPais = obtemBenchmarkPais(pais, stringDataInicial, stringDataFinal);
		return conversorDados.converterDadosParaJson(benchmarkPais, BenchmarkPais.class);
	}
	
	public BenchmarkPais obtemBenchmarkPais(String pais, String stringDataInicial, String stringDataFinal) {
		LocalDate dataInicial = converteStringParaData(stringDataInicial);
		LocalDate dataFinal = converteStringParaData(stringDataFinal);
		ExternalPacoteCasosEMortes externalPacoteCasosEMortes = externalPaisesServices.obtemPacoteCasosEMortes(pais);
		externalPacoteCasosEMortes.setDataInicio(dataInicial);
		externalPacoteCasosEMortes.setDataFinal(dataFinal);
		return processadorBenchmarkPais.processar(externalPacoteCasosEMortes);
	}
	
	
	private LocalDate converteStringParaData(String stringData) {
		return LocalDate.parse(stringData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
}
