package br.com.sergio.api.covid.processador;

import br.com.sergio.api.covid.external.ExternalDadosPorDia;
import br.com.sergio.api.covid.external.ExternalPacoteCasosEMortes;
import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.model.DadosPorDia;
import br.com.sergio.api.covid.model.JsonsBenchmarkPais;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class ProcessadorBenchmarkPais {
	
	private ProcessadorDadosDia processadorDadosDia;
	
	private ProcessadorJsonBenchmarkPais processadorJsonBenchmarkPais;
	
	public ProcessadorBenchmarkPais(ProcessadorJsonBenchmarkPais processadorJsonBenchmarkPais, ProcessadorDadosDia processadorDadosDia) {
		this.processadorDadosDia = processadorDadosDia;
		this.processadorJsonBenchmarkPais = processadorJsonBenchmarkPais;
	}
	
	public BenchmarkPais processar(ExternalPacoteCasosEMortes externalPacoteCasosEMortes) {
		List<DadosPorDia> mortesPorDia = trataMapDadosDia(externalPacoteCasosEMortes.getDadosMortes(),
				externalPacoteCasosEMortes.getDataInicio(), externalPacoteCasosEMortes.getDataFinal());
		List<DadosPorDia> casosPorDia = trataMapDadosDia(externalPacoteCasosEMortes.getDadosCasos(),
				externalPacoteCasosEMortes.getDataInicio(), externalPacoteCasosEMortes.getDataFinal());
		JsonsBenchmarkPais jsonsBenchmarkPais = processadorJsonBenchmarkPais.converteDadosDiaParaJson(casosPorDia, mortesPorDia);
		
		BenchmarkPais benchmarkPais = new BenchmarkPais();
		benchmarkPais.setNomePais(externalPacoteCasosEMortes.getPais());
		benchmarkPais.setMortesNoPeriodo(processadorDadosDia.obtemTotalNoPeriodo(mortesPorDia));
		benchmarkPais.setCasosNoPeriodo(processadorDadosDia.obtemTotalNoPeriodo(casosPorDia));
		benchmarkPais.setDataInicial(Date.valueOf(externalPacoteCasosEMortes.getDataInicio()));
		benchmarkPais.setDataFinal(Date.valueOf(externalPacoteCasosEMortes.getDataFinal()));
		benchmarkPais.setJsonsBenchmarkPais(jsonsBenchmarkPais);
		jsonsBenchmarkPais.setBenchmarkPais(benchmarkPais);
		return benchmarkPais;
	}
	
	private List<DadosPorDia> trataMapDadosDia(Map<String, ExternalDadosPorDia> mapDados, LocalDate dataInicial,
											   LocalDate dataFinal) {
		List<DadosPorDia> casosPorDia = processadorDadosDia.converteDadosPorDia(mapDados);
		return processadorDadosDia.filtraPorPeriodo(casosPorDia, dataInicial, dataFinal);
	}
	
}
