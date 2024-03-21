package br.com.sergio.api.covid.rest.controller;


import static br.com.sergio.api.covid.utils.Constantes.CASOS;
import static br.com.sergio.api.covid.utils.Constantes.MORTES;

import br.com.sergio.api.covid.rest.service.PaisesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paises/")
public class PaisesRestController {
	
	private PaisesService paisesService;
	
	public PaisesRestController(PaisesService paisesService) {
		this.paisesService = paisesService;
	}
	
	@GetMapping("/casos/{pais}")
	public String obtemCasosPorPais(@PathVariable String pais) {
		return paisesService.obtemPaisesDaOrigem(pais, CASOS);
	}
	
	@GetMapping("/mortes/{pais}")
	public String obtemMortesPorPais(@PathVariable String pais) {
		return paisesService.obtemPaisesDaOrigem(pais, MORTES);
	}
	
}
