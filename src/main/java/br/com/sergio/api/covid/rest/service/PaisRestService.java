package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.service.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaisRestService {
	private PaisService paisService;
	
	public PaisRestService(PaisService paisService) {
		this.paisService = paisService;
	}
	
	public ResponseEntity<List<String>> obtemNomesPaisesSemAcentuacao(){
		List<Pais> listaPais = paisService.obtemTodosPaises();
		List<String> listaNomes = new ArrayList<>();
		listaPais.forEach(p -> {
			listaNomes.add(p.getNomeSemAcentuacao().toLowerCase());
		});
		return new ResponseEntity<>(listaNomes, HttpStatus.OK);
	}
}
