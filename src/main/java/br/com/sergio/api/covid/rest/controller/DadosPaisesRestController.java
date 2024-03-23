package br.com.sergio.api.covid.rest.controller;


import static br.com.sergio.api.covid.utils.Constantes.CASOS;
import static br.com.sergio.api.covid.utils.Constantes.MORTES;

import br.com.sergio.api.covid.rest.service.DadosPaisesRestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dados/paises/")
public class DadosPaisesRestController {
	
	private DadosPaisesRestService dadosPaisesRestService;
	
	public DadosPaisesRestController(DadosPaisesRestService dadosPaisesRestService) {
		this.dadosPaisesRestService = dadosPaisesRestService;
	}
	
	@GetMapping("/casos/{pais}")
	public String obtemCasosPorPais(@PathVariable String pais) {
		return dadosPaisesRestService.obtemPaisesDaOrigem(pais, CASOS);
	}
	
	@GetMapping("/mortes/{pais}")
	public String obtemMortesPorPais(@PathVariable String pais) {
		return dadosPaisesRestService.obtemPaisesDaOrigem(pais, MORTES);
	}
	
}
