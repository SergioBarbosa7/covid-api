package br.com.sergio.api.covid.processador;

import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.model.BenchmarkTotal;
import org.springframework.stereotype.Component;

@Component
public class ProcessadorBenchmarkTotal {
	
	public BenchmarkTotal processaBenchmarkTotal(String nome, BenchmarkPais benchmarkPais1, BenchmarkPais benchmarkPais2){
		BenchmarkTotal benchmarkTotal = new BenchmarkTotal();
		benchmarkTotal.setDataInicial(benchmarkPais1.getDataInicial());
		benchmarkTotal.setDataFinal(benchmarkPais1.getDataFinal());
		benchmarkTotal.setNomeBenchmark(nome);
		benchmarkTotal.setBenchmarkPais1(benchmarkPais1);
		benchmarkTotal.setBenchmarkPais2(benchmarkPais2);
		return benchmarkTotal;
	}
}
