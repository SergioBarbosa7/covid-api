package br.com.sergio.api.covid.rest.controller;

import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.rest.service.PaisRestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/paises/")
public class PaisRestController {
	
	PaisRestService paisRestService;
	
	public PaisRestController(PaisRestService paisRestService) {
		this.paisRestService = paisRestService;
	}
	
	@GetMapping("/lista/")
	public ResponseEntity<List<String>> obtemPaisesDisponiveis (){
		return paisRestService.obtemNomesPaisesSemAcentuacao();
	}
	
}
