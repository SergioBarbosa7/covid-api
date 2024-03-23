package br.com.sergio.api.covid.rest.dto.factory;

import br.com.sergio.api.covid.model.BenchmarkTotal;
import br.com.sergio.api.covid.rest.dto.ResumoBenchmarkDTO;
import org.springframework.stereotype.Component;

@Component
public class ResumoBenchmarkDTOFactory {
	
	public ResumoBenchmarkDTO geraResumoBenchmark(BenchmarkTotal benchmarkTotal){
		ResumoBenchmarkDTO dto = new ResumoBenchmarkDTO();
		dto.setIdBenchmark(benchmarkTotal.getId());
		dto.setNome(benchmarkTotal.getNomeBenchmark());
		dto.setDataInicial(benchmarkTotal.getDataInicial());
		dto.setDataFinal(benchmarkTotal.getDataFinal());
		dto.setNomePais1(benchmarkTotal.getBenchmarkPais1().getNomePais());
		dto.setNomePais2(benchmarkTotal.getBenchmarkPais2().getNomePais());
		return dto;
	}

}
