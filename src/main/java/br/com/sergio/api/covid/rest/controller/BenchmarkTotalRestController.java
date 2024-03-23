package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.dto.BenchmarkTotalDTO;
import br.com.sergio.api.covid.rest.dto.ResumoBenchmarkDTO;
import br.com.sergio.api.covid.rest.service.BenchmarkTotalRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/benchmark/total/")
public class BenchmarkTotalRestController {
	
	BenchmarkTotalRestService benchmarkRestService;
	
	public BenchmarkTotalRestController(BenchmarkTotalRestService benchmarkRestService) {
		this.benchmarkRestService = benchmarkRestService;
	}
	
	@PostMapping("{nome}/paises/{pais1}/{pais2}/data/{dataInicial}/to/{dataFinal}")
	public ResponseEntity<ResumoBenchmarkDTO> criaBenchmarkTotal(@PathVariable String nome,
																 @PathVariable String pais1,
																 @PathVariable String pais2,
																 @PathVariable String dataInicial,
																 @PathVariable String dataFinal) {
		 return benchmarkRestService.criaBenchmarkTotal(nome, pais1, pais2, dataInicial, dataFinal);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ResumoBenchmarkDTO>> obtemListaBenchmarks(){
		return benchmarkRestService.obtemListaBenchmarks();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletaBenchmarkPeloId(@PathVariable Long id) {
		return benchmarkRestService.deletaBenchmarkPeloId(id);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<BenchmarkTotalDTO> obtemBenchmarkPeloId(@PathVariable Long id) {
		return benchmarkRestService.obtemBenchmarkTotalPeloId(id);
	}
	
}
