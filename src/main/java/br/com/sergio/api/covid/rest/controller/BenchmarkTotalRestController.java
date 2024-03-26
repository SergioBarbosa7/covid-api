package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.dto.BenchmarkTotalDTO;
import br.com.sergio.api.covid.rest.dto.ResumoBenchmarkDTO;
import br.com.sergio.api.covid.rest.requerst.BenchmarkRequest;
import br.com.sergio.api.covid.rest.service.BenchmarkTotalRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Tag(name = "Benchmarks de comparação", description = "Realiza as operações de benchmarks entre países")
@RestController
@RequestMapping(value = "/api/benchmark/total/")
public class BenchmarkTotalRestController {
	
	private final BenchmarkTotalRestService benchmarkRestService;
	
	public BenchmarkTotalRestController(BenchmarkTotalRestService benchmarkRestService) {
		this.benchmarkRestService = benchmarkRestService;
	}
	
	@Operation(summary = "Cria uma Benchmark entre países", description = "Cria uma benchmark entre dois países e " +
			"retorna seu resumo")
	@PostMapping(value = "/criar/")
	public ResponseEntity<ResumoBenchmarkDTO> criaBenchmarkTotal(
			@Parameter(name = "Corpo da requisição para criar uma benchmark entre países", content = @Content(schema
					= @Schema(implementation = BenchmarkRequest.class))) @RequestBody BenchmarkRequest request) {
		return benchmarkRestService.criaBenchmarkTotal(request.getNome(), request.getNomePais1(),
				request.getNomePais2(), request.getDataInicial(), request.getDataFinal());
	}
	
	@Operation(summary = "Lista as Benchmarks", description = "Disponibiliza uma lista de resumos das Benchmarks")
	@GetMapping(value = "/lista")
	public ResponseEntity<List<ResumoBenchmarkDTO>> obtemListaBenchmarks() {
		return benchmarkRestService.obtemListaBenchmarks();
	}
	
	@Operation(summary = "Obtem uma Benchmark", description = "Obtem uma benchmark pelo ID")
	@GetMapping(value = "/{id}/")
	public ResponseEntity<BenchmarkTotalDTO> obtemBenchmarkPeloId(
			@PathVariable("id") @Parameter(name = "id") Long id) {
		return benchmarkRestService.obtemBenchmarkTotalPeloId(id);
	}
	
	@Operation(summary = "Deleta uma Benchmark", description = "Deleta uma benchmark pelo ID")
	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> deletaBenchmarkPeloId(@PathVariable("id") @Parameter(name = "id") Long id) {
		return benchmarkRestService.deletaBenchmarkPeloId(id);
	}
	
}
