package br.com.sergio.api.covid.service;

import br.com.sergio.api.covid.exceptions.NaoEncontradoException;
import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.repository.PaisRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaisService {
	
	private PaisRepository paisRepository;
	
	public PaisService(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}
	
	public List<Pais> obtemTodosPaises(){
		return paisRepository.findAll();
	}
	
	public Boolean paisesJaForamCarregados(){
		return !obtemTodosPaises().isEmpty();
	}
	
	public void salvaPais(Pais pais){
		paisRepository.saveAndFlush(pais);
	}
	public Pais obtemPaisPeloNome(String nomePais){
		Pais pais = paisRepository.obtemPaisPeloNomeEmPortugues(nomePais.toLowerCase());
		if(pais != null){
			return pais;
		}
		throw new NaoEncontradoException(Pais.class.getSimpleName(), nomePais);
	}
	public String obtemNomeDoPaisEmIngles(String pais){
		return obtemPaisPeloNome(pais).getNomeIngles();
	}
}
