package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.service.BenchmarkTotalRestService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/benchmark/total/")
public class BenchmarkTotalRestController {
	
	BenchmarkTotalRestService benchmarkRestService;
	
	public BenchmarkTotalRestController(BenchmarkTotalRestService benchmarkRestService) {
		this.benchmarkRestService = benchmarkRestService;
	}
	
	@PostMapping("{nome}/paises/{pais1}/{pais2}/data/{dataInicial}/to/{dataFinal}")
	public String criaBenchmarkTotal(@PathVariable String nome,
									 @PathVariable String pais1,
									 @PathVariable String pais2,
									 @PathVariable String dataInicial,
									 @PathVariable String dataFinal) {
		 return benchmarkRestService.criaBenchmarkTotal(nome, pais1, pais2, dataInicial, dataFinal);
	}
	
	@DeleteMapping("/{id}")
	public String deletaBenchmarkPeloId(@PathVariable Long id) {
		return null;
	}
	
	@GetMapping("/{id}")
	public String obtemBenchmarkPeloId(@PathVariable Long id) {
		return null;
	}
	
}
