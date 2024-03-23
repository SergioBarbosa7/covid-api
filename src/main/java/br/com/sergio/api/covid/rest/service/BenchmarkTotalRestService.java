package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.model.BenchmarkTotal;
import br.com.sergio.api.covid.rest.dto.BenchmarkTotalDTO;
import br.com.sergio.api.covid.rest.dto.ResumoBenchmarkDTO;
import br.com.sergio.api.covid.service.BenchmarkTotalService;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BenchmarkTotalRestService {
	
	BenchmarkTotalService benchmarkTotalService;
	ConversorDados conversorDados;
	
	public BenchmarkTotalRestService(BenchmarkTotalService benchmarkTotalService, ConversorDados conversorDados) {
		this.benchmarkTotalService = benchmarkTotalService;
		this.conversorDados = conversorDados;
	}
	
	public ResponseEntity<ResumoBenchmarkDTO> criaBenchmarkTotal(String nome, String pais1, String pais2, String dataInicial, String dataFinal) {
		return new ResponseEntity<>(benchmarkTotalService.criaBenchmarkTotal(nome, pais1, pais2, dataInicial,
				dataFinal), HttpStatus.OK);
	}
	
	public ResponseEntity<BenchmarkTotalDTO> obtemBenchmarkTotalPeloId(Long id) {
		BenchmarkTotalDTO benchmarkTotal = benchmarkTotalService.obtemBenchmarkTotalPeloId(id);
		if (benchmarkTotal != null) {
			return new ResponseEntity<>(benchmarkTotal, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<String> deletaBenchmarkPeloId(Long id) {
		benchmarkTotalService.deletaBenchmarkTotalPeloID(id);
		return new ResponseEntity<>("BenchmarkDeletada", HttpStatus.OK);
	}
	
	public ResponseEntity<List<ResumoBenchmarkDTO>> obtemListaBenchmarks() {
		List<ResumoBenchmarkDTO> lista = benchmarkTotalService.obterListaBenchmarks();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
