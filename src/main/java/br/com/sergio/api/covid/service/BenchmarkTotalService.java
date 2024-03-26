package br.com.sergio.api.covid.service;

import br.com.sergio.api.covid.exceptions.NaoEncontradoException;
import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.model.BenchmarkTotal;
import br.com.sergio.api.covid.processador.ProcessadorBenchmarkTotal;
import br.com.sergio.api.covid.repository.BenchmarkTotalRepository;
import br.com.sergio.api.covid.rest.dto.BenchmarkTotalDTO;
import br.com.sergio.api.covid.rest.dto.ResumoBenchmarkDTO;
import br.com.sergio.api.covid.rest.dto.factory.BenchmarkDTOFactory;
import br.com.sergio.api.covid.rest.dto.factory.ResumoBenchmarkDTOFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BenchmarkTotalService {
	
	private final BenchmarkPaisService benchmarkPaisService;
	private final ProcessadorBenchmarkTotal processadorBenchmarkTotal;
	private final ResumoBenchmarkDTOFactory resumoBenchmarkDTOFactory;
	private final BenchmarkTotalRepository benchmarkTotalRepository;
	private final BenchmarkDTOFactory benchmarkDTOFactory;
	private static final Logger LOG = LogManager.getLogger(BenchmarkTotalService.class);
	
	public BenchmarkTotalService(BenchmarkPaisService benchmarkPaisService,
								 ProcessadorBenchmarkTotal processadorBenchmarkTotal,
								 BenchmarkTotalRepository benchmarkTotalRepository,
								 BenchmarkDTOFactory benchmarkDTOFactory,
								 ResumoBenchmarkDTOFactory resumoBenchmarkDTOFactory) {
		this.benchmarkPaisService = benchmarkPaisService;
		this.processadorBenchmarkTotal = processadorBenchmarkTotal;
		this.benchmarkTotalRepository = benchmarkTotalRepository;
		this.benchmarkDTOFactory = benchmarkDTOFactory;
		this.resumoBenchmarkDTOFactory = resumoBenchmarkDTOFactory;
	}
	
	public ResumoBenchmarkDTO criaBenchmarkTotal(String nome, String pais1, String pais2, String dataInicial,
												 String dataFinal) {
		
		BenchmarkPais benchmarkPais1 = benchmarkPaisService.obtemBenchmarkPais(pais1, dataInicial, dataFinal);
		BenchmarkPais benchmarkPais2 = benchmarkPaisService.obtemBenchmarkPais(pais2, dataInicial, dataFinal);
		BenchmarkTotal benchmarkTotal = processadorBenchmarkTotal.processaBenchmarkTotal(nome, benchmarkPais1,
				benchmarkPais2);
		return resumoBenchmarkDTOFactory.geraResumoBenchmark(benchmarkTotalRepository.saveAndFlush(benchmarkTotal));
	}
	
	public BenchmarkTotalDTO obtemBenchmarkTotalPeloId(Long id) {
		Optional<BenchmarkTotal> optionalBenchmark = benchmarkTotalRepository.findById(id);
		if (optionalBenchmark.isPresent()) {
			return benchmarkDTOFactory.geraDTOBenchmark(optionalBenchmark.get());
		}
		throw new NaoEncontradoException(BenchmarkTotal.class.getSimpleName(), id.toString());
	}
	
	public void deletaBenchmarkTotalPeloID(Long id) {
		benchmarkTotalRepository.deleteById(id);
	}
	
	public List<ResumoBenchmarkDTO> obterListaBenchmarks() {
		List<ResumoBenchmarkDTO> lista = new ArrayList<>();
		benchmarkTotalRepository.findAll().forEach(b -> {
			LOG.info("Adicionando resumo de benchmark {} para a lista", b.getNomeBenchmark());
			lista.add(resumoBenchmarkDTOFactory.geraResumoBenchmark(b));
		});
		return lista;
	}
}