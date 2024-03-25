package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.rest.dto.BenchmarkPaisDTO;
import br.com.sergio.api.covid.service.BenchmarkPaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BenchmarkRestService {
	
	private final BenchmarkPaisService benchmarkPaisService;
	
	BenchmarkRestService(BenchmarkPaisService benchmarkPaisService) {
		this.benchmarkPaisService = benchmarkPaisService;
	}
	
	public ResponseEntity<BenchmarkPaisDTO> obtemBenchmarkPais(String pais, String stringDataInicial,
															   String stringDataFinal) {
		return new ResponseEntity<>(benchmarkPaisService.obtemBenchmarkPaisDTO(pais, stringDataInicial, stringDataFinal),
				HttpStatus.OK);
		
	}
	
}
