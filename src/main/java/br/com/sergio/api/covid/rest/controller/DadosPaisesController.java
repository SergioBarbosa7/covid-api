package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.comunicacao.ConsumoApi;
import br.com.sergio.api.covid.rest.service.PaisesService;
import br.com.sergio.api.covid.utils.ConstrutorDeURL;
import br.com.sergio.api.covid.utils.ConversorDados;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api")
public class DadosPaisesController {
	
	PaisesService paisesService;
	
	public DadosPaisesController(PaisesService paisesService) {
		this.paisesService = paisesService;
	}
	
	@GetMapping("/paises/casos/{pais}")
	public String obtemCasosPorPais(@PathVariable String pais) throws URISyntaxException {
		try {
			return paisesService.obtemPaisesDaOrigem(pais, "cases");
			
		} catch (URISyntaxException ure) {
			return "Erro ao montar a url";
		}
	}
	
	@GetMapping("/paises/mortes/{pais}")
	public String obtemMortesPorPais(@PathVariable String pais) {
		try {
			return paisesService.obtemPaisesDaOrigem(pais, "deaths");
		} catch (URISyntaxException ure) {
			return "Erro ao montar a url";
		}
	}
	
}
