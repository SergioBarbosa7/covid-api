package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.dto.BenchmarkPaisDTO;
import br.com.sergio.api.covid.rest.service.BenchmarkRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Benchmark do País", description = "Obtem uma benchmark de um país")
@RestController
@RequestMapping(value = "/api/benchmark/paises/")
public class BenchmarkPaisRestController {
	
	private final BenchmarkRestService benchmarkRestService;
	
	public BenchmarkPaisRestController(BenchmarkRestService benchmarkRestService) {
		this.benchmarkRestService = benchmarkRestService;
	}
	
	@Operation(summary = "Obtem uma benchmark", description = "Cria uma benchmark de um país")
	@GetMapping(value = "/{pais}/{dataInicial}/{dataFinal}")
	public ResponseEntity<BenchmarkPaisDTO> criaBenchmarkPorPais(@PathVariable String pais, @PathVariable String dataInicial,
																 @PathVariable String dataFinal) {
		return benchmarkRestService.obtemBenchmarkPais(pais, dataInicial, dataFinal);
	}

}
