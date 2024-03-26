package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.rest.dto.BenchmarkPaisDTO;
import br.com.sergio.api.covid.service.BenchmarkPaisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BenchmarkRestService {
	
	private final BenchmarkPaisService benchmarkPaisService;
	private static final Logger LOG = LogManager.getLogger(BenchmarkRestService.class);
	
	BenchmarkRestService(BenchmarkPaisService benchmarkPaisService) {
		this.benchmarkPaisService = benchmarkPaisService;
	}
	
	public ResponseEntity<BenchmarkPaisDTO> obtemBenchmarkPais(String pais, String stringDataInicial,
															   String stringDataFinal) {
		LOG.info("Processando requisição para geração de Benchmark de pais para o país {} com datas {} até {}", pais,
				stringDataInicial, stringDataFinal);
		return new ResponseEntity<>(
				benchmarkPaisService.obtemBenchmarkPaisDTO(pais, stringDataInicial, stringDataFinal), HttpStatus.OK);
		
	}
	
}
