package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.rest.dto.BenchmarkTotalDTO;
import br.com.sergio.api.covid.rest.dto.ResumoBenchmarkDTO;
import br.com.sergio.api.covid.service.BenchmarkTotalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BenchmarkTotalRestService {
	
	private final BenchmarkTotalService benchmarkTotalService;
	private static final Logger LOG = LogManager.getLogger(BenchmarkTotalRestService.class);
	
	public BenchmarkTotalRestService(BenchmarkTotalService benchmarkTotalService) {
		this.benchmarkTotalService = benchmarkTotalService;
	}
	
	public ResponseEntity<ResumoBenchmarkDTO> criaBenchmarkTotal(String nome, String pais1, String pais2,
																 String dataInicial, String dataFinal) {
		LOG.info(
				"Processando requisição de criação de benchmark de nome {} para os países {}<>{}, para as datas {} " +
						"até {}",
				nome, pais1, pais2, dataInicial, dataFinal);
		return new ResponseEntity<>(
				benchmarkTotalService.criaBenchmarkTotal(nome, pais1, pais2, dataInicial, dataFinal), HttpStatus.OK);
	}
	
	public ResponseEntity<BenchmarkTotalDTO> obtemBenchmarkTotalPeloId(Long id) {
		LOG.info("Processando requisição para buscar benchmark de id {}", id);
		BenchmarkTotalDTO benchmarkTotal = benchmarkTotalService.obtemBenchmarkTotalPeloId(id);
		if (benchmarkTotal != null) {
			return new ResponseEntity<>(benchmarkTotal, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<String> deletaBenchmarkPeloId(Long id) {
		LOG.info("Processando requisição para deletar benchmark de id {}", id);
		benchmarkTotalService.deletaBenchmarkTotalPeloID(id);
		return new ResponseEntity<>("BenchmarkDeletada", HttpStatus.OK);
	}
	
	public ResponseEntity<List<ResumoBenchmarkDTO>> obtemListaBenchmarks() {
		LOG.info("Obtendo lista das benchmarks do banco");
		List<ResumoBenchmarkDTO> lista = benchmarkTotalService.obterListaBenchmarks();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
