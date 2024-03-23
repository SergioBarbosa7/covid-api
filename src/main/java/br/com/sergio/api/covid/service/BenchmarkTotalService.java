package br.com.sergio.api.covid.service;

import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.model.BenchmarkTotal;
import br.com.sergio.api.covid.processador.ProcessadorBenchmarkTotal;
import br.com.sergio.api.covid.repository.BenchmarkTotalRepository;
import br.com.sergio.api.covid.utils.ConversorDados;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BenchmarkTotalService {
	
	BenchmarkPaisService benchmarkPaisService;
	ProcessadorBenchmarkTotal processadorBenchmarkTotal;
	ConversorDados conversorDados;
	BenchmarkTotalRepository benchmarkTotalRepository;
	
	public BenchmarkTotalService(BenchmarkPaisService benchmarkPaisService,
								 ProcessadorBenchmarkTotal processadorBenchmarkTotal,
								 BenchmarkTotalRepository benchmarkTotalRepository) {
		this.benchmarkPaisService = benchmarkPaisService;
		this.processadorBenchmarkTotal = processadorBenchmarkTotal;
		this.benchmarkTotalRepository = benchmarkTotalRepository;
	}
	
	public BenchmarkTotal criaBenchmarkTotal(String nome, String pais1, String pais2, String dataInicial,
											 String dataFinal) {
		BenchmarkPais benchmarkPais1 = benchmarkPaisService.obtemBenchmarkPais(pais1, dataInicial, dataFinal);
		BenchmarkPais benchmarkPais2 = benchmarkPaisService.obtemBenchmarkPais(pais2, dataInicial, dataFinal);
		BenchmarkTotal benchmarkTotal = processadorBenchmarkTotal.processaBenchmarkTotal(nome, benchmarkPais1,
				benchmarkPais2);
		return benchmarkTotalRepository.saveAndFlush(benchmarkTotal);
	}
	
	public BenchmarkTotalDTO obtemBenchmarkTotalPeloId(Long id) {
		Optional<BenchmarkTotal> optionalBenchmark = benchmarkTotalRepository.findById(id);
		if (optionalBenchmark.isPresent()) {
			return benchmarkDTOFactory.geraDTOBenchmark(optionalBenchmark.get());
		}
		return null;
	}
	
}