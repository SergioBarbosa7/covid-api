package br.com.sergio.api.covid.rest.service;

import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.service.PaisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaisRestService {
	private final PaisService paisService;
	private static final Logger LOG = LogManager.getLogger(PaisRestService.class);
	
	public PaisRestService(PaisService paisService) {
		this.paisService = paisService;
	}
	
	public ResponseEntity<List<String>> obtemNomesPaisesSemAcentuacao(){
		LOG.info("Buscando países sem acentuação");
		List<Pais> listaPais = paisService.obtemTodosPaises();
		List<String> listaNomes = new ArrayList<>();
		listaPais.forEach(p -> {
			listaNomes.add(p.getNomeSemAcentuacao());
		});
		return new ResponseEntity<>(listaNomes, HttpStatus.OK);
	}
	
	public ResponseEntity<List<String>> obtemNomesPaises(){
		LOG.info("Buscando países com acentuação");
		List<Pais> listaPais = paisService.obtemTodosPaises();
		List<String> listaNomes = new ArrayList<>();
		listaPais.forEach(p -> {
			listaNomes.add(p.getNomePortugues());
		});
		return new ResponseEntity<>(listaNomes, HttpStatus.OK);
	}
}
