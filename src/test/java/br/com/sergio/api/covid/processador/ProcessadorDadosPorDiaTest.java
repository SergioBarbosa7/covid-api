package br.com.sergio.api.covid.processador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.sergio.api.covid.model.DadosPorDia;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProcessadorDadosPorDiaTest {
	
	@Resource
	private ProcessadorDadosDia processadorDadosDia;
	
	private List<DadosPorDia> carregaDadosPorDia() {
		List<DadosPorDia> listaDados = new ArrayList<>();
		listaDados.add(new DadosPorDia("2024-01-01", 50000, 500));
		listaDados.add(new DadosPorDia("2023-01-01", 40000, 350));
		listaDados.add(new DadosPorDia("2022-01-01", 30000, 50));
		return listaDados;
	}
	
	@Test
	public void validaMaximo() {
		List<DadosPorDia> lista = carregaDadosPorDia();
		Integer max = processadorDadosDia.obtemTotalFinal(lista);
		assertEquals(50000, max);
	}
	
	@Test
	public void validaInicial() {
		List<DadosPorDia> lista = carregaDadosPorDia();
		Integer min = processadorDadosDia.obtemTotalInicial(lista);
		assertEquals(30000, min);
	}
	
	@Test
	public void validaTotalNoPeriodo() {
		List<DadosPorDia> lista = carregaDadosPorDia();
		Integer total = processadorDadosDia.obtemTotalNoPeriodo(lista);
		assertEquals(20000, total);
	}
	
	@Test
	public void validaPico() {
		List<DadosPorDia> lista = carregaDadosPorDia();
		DadosPorDia pico = processadorDadosDia.obtemPicoPorDia(lista);
		assertEquals(500, pico.getNovos());
		assertEquals("2024-01-01", pico.getData().toString());
	}
	
}
