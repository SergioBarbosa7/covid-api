package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.rest.service.PaisRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Tag(name = "Países", description = "Retorna uma lista dos países disponíveis na aplicação")
@RestController
@RequestMapping(value = "/api/paises/")
public class PaisRestController {
	
	private final PaisRestService paisRestService;
	
	public PaisRestController(PaisRestService paisRestService) {
		this.paisRestService = paisRestService;
	}
	
	@Operation(summary = "Obtem uma lista dos países")
	@GetMapping(value = "/lista/")
	public ResponseEntity<List<String>> obtemPaisesDisponiveis (){
		return paisRestService.obtemNomesPaises();
	}
	
	@Operation(summary = "Obtem uma lista dos países sem acentuação")
	@GetMapping(value = "/lista/sem-acentuacao")
	public ResponseEntity<List<String>> obtemPaisesDisponiveisSemAcentuacao (){
		return paisRestService.obtemNomesPaisesSemAcentuacao();
	}
}
