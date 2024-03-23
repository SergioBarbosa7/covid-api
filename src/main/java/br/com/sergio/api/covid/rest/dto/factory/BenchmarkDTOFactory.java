package br.com.sergio.api.covid.rest.dto.factory;

import br.com.sergio.api.covid.model.BenchmarkPais;
import br.com.sergio.api.covid.model.BenchmarkTotal;
import br.com.sergio.api.covid.rest.dto.BenchmarkPaisDTO;
import br.com.sergio.api.covid.rest.dto.BenchmarkTotalDTO;

public class BenchmarkDTOFactory {

	public BenchmarkTotalDTO geraDTOBenchmark(BenchmarkTotal benchmarkTotal){
	
	}
	
	public BenchmarkPaisDTO geraDTOBenchmarkPais(BenchmarkPais benchmarkPais) {
		BenchmarkPaisDTO dto = new BenchmarkPaisDTO();
		
		dto.setNomePais(benchmarkPais.getNomePais());
		dto.setCasosNoPeriodo(benchmarkPais.getCasosNoPeriodo());
		dto.setMortesNoPeriodo(benchmarkPais.getMortesNoPeriodo());
		dto.setDataInicial(benchmarkPais.getDataInicial());
		dto.setDataFinal(benchmarkPais.getDataFinal());
		preencheDiferencaDeDatas(dto);
		preencherEstatisticasPais(dto, benchmarkPais);
		return dto;
	}
	
	public void preencherEstatisticasPais(BenchmarkPaisDTO dto, BenchmarkPais benchmarkPais) {
		Double mortalidade = (double) (benchmarkPais.getMortesNoPeriodo() / benchmarkPais.getCasosNoPeriodo()) * 100;
		dto.setTaxaDeMortalidade(mortalidade);
		preencherEstatisticasMortePais(dto, processadorDadosDia.obtemDadosPorDiaDoJson(
				benchmarkPais.getJsonsBenchmarkPais().getJsonMortes()));
		preencherEstatisticasCasosPais(dto, processadorDadosDia.obtemDadosPorDiaDoJson(
				benchmarkPais.getJsonsBenchmarkPais().getJsonCasos()));
	}
	
	public void preencherEstatisticasMortePais(BenchmarkPaisDTO dto, List<DadosPorDia> dadosMortes) {
		dto.setMortesIniciais(processadorDadosDia.obtemTotalInicial(dadosMortes));
		DadosPorDia dadosPico = processadorDadosDia.obtemPicoPorDia(dadosMortes);
		dto.setPicoDeMortes(dadosPico.getNovos());
		dto.setDataPicoDeMortes(Date.valueOf(dadosPico.getData()));
		dto.setMediaDeMortesPorDia(dto.getMortesNoPeriodo()/ dto.getDiasNoPeriodo());
	}
	
	public void preencherEstatisticasCasosPais(BenchmarkPaisDTO dto, List<DadosPorDia> dadosCasos) {
		dto.setCasosIniciais(processadorDadosDia.obtemTotalInicial(dadosCasos));
		DadosPorDia dadosPico = processadorDadosDia.obtemPicoPorDia(dadosCasos);
		dto.setPicoDeCasos(dadosPico.getNovos());
		dto.setDataPicoDeCasos(Date.valueOf(dadosPico.getData()));
		dto.setMediaDeCasosPorDia(dto.getCasosNoPeriodo()/ dto.getDiasNoPeriodo());
	}
	
	public void preencheDiferencaDeDatas(BenchmarkPaisDTO dto){
		long diferenca = dto.getDataFinal().getTime() - dto.getDataInicial().getTime();
		dto.setDiasNoPeriodo((int) TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS));
	}
}
