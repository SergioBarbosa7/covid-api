package br.com.sergio.api.covid.conversor.impl;

import br.com.sergio.api.covid.conversor.IConversor;
import br.com.sergio.api.covid.external.ExternalDadosPorDia;
import br.com.sergio.api.covid.model.DadosPorDia;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConversorMapDadosExternosToListDadosPorDia
		implements IConversor<Map<String, ExternalDadosPorDia>, List<DadosPorDia>> {
	
	@Override
	public List<DadosPorDia> converter(Map<String, ExternalDadosPorDia> entrada) {
		List<DadosPorDia> listaDados = new ArrayList<>();
		for (Map.Entry<String, ExternalDadosPorDia> entry : entrada.entrySet()) {
			DadosPorDia dadosPorDia = new DadosPorDia();
			dadosPorDia.setNovos(entry.getValue().getNovos());
			dadosPorDia.setTotal(entry.getValue().getTotal());
			try {
				LocalDate date = LocalDate.parse(entry.getKey(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				dadosPorDia.setData(date);
			} catch (DateTimeParseException e) {
				dadosPorDia.setData(null);
			}
			listaDados.add(dadosPorDia);
		}
		return listaDados;
	}
	
}

