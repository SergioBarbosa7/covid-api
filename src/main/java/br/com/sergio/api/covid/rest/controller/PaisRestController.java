package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.service.PaisRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/paises/")
public class PaisRestController {
	
	private PaisRestService paisRestService;
	
	public PaisRestController(PaisRestService paisRestService) {
		this.paisRestService = paisRestService;
	}
	
	@GetMapping(value = "/lista/")
	public ResponseEntity<List<String>> obtemPaisesDisponiveis (){
		return paisRestService.obtemNomesPaises();
	}
	
	@GetMapping(value = "/lista/sem-acentuacao")
	public ResponseEntity<List<String>> obtemPaisesDisponiveisSemAcentuacao (){
		return paisRestService.obtemNomesPaisesSemAcentuacao();
	}
}
