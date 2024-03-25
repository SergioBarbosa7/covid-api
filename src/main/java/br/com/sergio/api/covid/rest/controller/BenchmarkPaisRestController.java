package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.dto.BenchmarkPaisDTO;
import br.com.sergio.api.covid.rest.service.BenchmarkRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/benchmark/paises/")
public class BenchmarkPaisRestController {
	
	private BenchmarkRestService benchmarkRestService;
	
	public BenchmarkPaisRestController(BenchmarkRestService benchmarkRestService) {
		this.benchmarkRestService = benchmarkRestService;
	}
	
	@PostMapping(value = "/{pais}/{dataInicial}/{dataFinal}")
	public ResponseEntity<BenchmarkPaisDTO> criaBenchmarkPorPais(@PathVariable String pais, @PathVariable String dataInicial,
																 @PathVariable String dataFinal) {
		return benchmarkRestService.obtemBenchmarkPais(pais, dataInicial, dataFinal);
	}

}
