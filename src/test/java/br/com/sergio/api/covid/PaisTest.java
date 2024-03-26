package br.com.sergio.api.covid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.repository.PaisRepository;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaisTest {

	@Resource
	private PaisRepository paisRepository;
	
	@Resource
	private ConversorDados conversorDados;
	
	private static final String JSON_PAIS = "{\n" + "    \"pais_sem_acentos\": \"Afeganistao\",\n" +
			"    \"pais_portugues\": \"Afeganistão\",\n" + "    \"pais_ingles\": \"Afghanistan\"\n" + "  }";
	
	@Test
	public void converteESalvaPaisTest(){
		Pais pais = conversorDados.converterDadosDoJson(JSON_PAIS, Pais.class);
		paisRepository.save(pais);
		
		Pais pais2 = paisRepository.findById(1L).get();
		assertNotNull(pais2);
		assertEquals(pais2.getNomeSemAcentuacao(), "Afeganistao");
	}
	
	@Test
	public void encontraPaisPeloNomeComAcentuacaoTest(){
		Pais pais = paisRepository.obtemPaisPeloNomeEmPortugues("Afeganistão".toLowerCase());
		assertNotNull(pais);
		assertEquals(pais.getNomePortugues(), "Afeganistão");
	}
	
	@Test
	public void encontraPaisPeloNomeSemAcentuacaoTest(){
		Pais pais = paisRepository.obtemPaisPeloNomeEmPortugues("Afeganistao".toLowerCase());
		assertNotNull(pais);
		assertEquals(pais.getNomeSemAcentuacao(), "Afeganistao");
	}
	
}
