package br.com.sergio.api.covid.service;

import br.com.sergio.api.covid.external.ExternalPacoteCasosEMortes;
import br.com.sergio.api.covid.external.service.ExternalDadosPaisesServices;
import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.processador.ProcessadorBenchmarkPais;
import br.com.sergio.api.covid.rest.dto.BenchmarkPaisDTO;
import br.com.sergio.api.covid.rest.dto.factory.BenchmarkDTOFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class BenchmarkPaisService {
	
	private final ProcessadorBenchmarkPais processadorBenchmarkPais;
	private final ExternalDadosPaisesServices externalPaisesServices;
	private final BenchmarkDTOFactory benchmarkDTOFactory;
	private static final Logger LOG = LogManager.getLogger(BenchmarkPaisService.class);
	
	public BenchmarkPaisService(ProcessadorBenchmarkPais processadorBenchmarkPais,
								ExternalDadosPaisesServices externalPaisesServices, BenchmarkDTOFactory benchmarkDTOFactory) {
		this.processadorBenchmarkPais = processadorBenchmarkPais;
		this.externalPaisesServices = externalPaisesServices;
		this.benchmarkDTOFactory = benchmarkDTOFactory;
	}
	
	public BenchmarkPais obtemBenchmarkPais(String pais, String stringDataInicial, String stringDataFinal) {
		LocalDate dataInicial = converteStringParaData(stringDataInicial);
		LocalDate dataFinal = converteStringParaData(stringDataFinal);
		ExternalPacoteCasosEMortes externalPacoteCasosEMortes = externalPaisesServices.obtemPacoteCasosEMortes(pais);
		externalPacoteCasosEMortes.setDataInicio(dataInicial);
		externalPacoteCasosEMortes.setDataFinal(dataFinal);
		return processadorBenchmarkPais.processar(externalPacoteCasosEMortes);
	}
	
	public BenchmarkPaisDTO obtemBenchmarkPaisDTO(String pais, String stringDataInicial, String stringDataFinal){
		return benchmarkDTOFactory.geraDTOBenchmarkPais(obtemBenchmarkPais( pais,  stringDataInicial,  stringDataFinal));
	}
	
	private LocalDate converteStringParaData(String stringData) {
		return LocalDate.parse(stringData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
}
