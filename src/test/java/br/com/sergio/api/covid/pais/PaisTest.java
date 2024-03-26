package br.com.sergio.api.covid.pais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.sergio.api.covid.model.Pais;
import br.com.sergio.api.covid.repository.PaisRepository;
import br.com.sergio.api.covid.utils.json.ConversorDados;
import jakarta.annotation.Resource;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PaisTest {
	
	@Resource
	private PaisRepository paisRepository;
	
	@Resource
	private ConversorDados conversorDados;
	
	private static final String JSON_AFEGANISTAO =
			"{\n" + "    \"pais_sem_acentos\": \"Afeganistao\",\n" + "    \"pais_portugues\": \"Afeganistão\",\n" +
					"    \"pais_ingles\": \"Afghanistan\"\n" + "  }";
	
	private static final String JSON_ALBANIA =
			"{\n" + "    \"pais_sem_acentos\": \"Albania\",\n" + "    \"pais_portugues\": \"Albânia\",\n" +
					"    \"pais_ingles\": \"Albania\"\n" + "  }";
	
	private static final String JSON_ARGELIA =
			"{\n" + "    \"pais_sem_acentos\": \"Argelia\",\n" + "    \"pais_portugues\": \"Argélia\",\n" +
					"    \"pais_ingles\": \"Algeria\"\n" + "  }";
	
	@Test
	public void converteESalvaPaisTest() {
		Pais pais = conversorDados.converterDadosDoJson(JSON_AFEGANISTAO, Pais.class);
		Pais pais2 = paisRepository.save(pais);
		
		assertNotNull(pais2);
		assertEquals(pais2.getNomeSemAcentuacao(), "Afeganistao");
	}
	
	@Test
	@Ignore
	public void encontraPaisPeloNomeComAcentuacaoTest() {
		Pais pais = conversorDados.converterDadosDoJson(JSON_ARGELIA, Pais.class);
		paisRepository.save(pais);
		
		Pais pais2 = paisRepository.obtemPaisPeloNomeEmPortugues("Argélia".toLowerCase());
		assertNotNull(pais2);
		assertEquals(pais2.getNomePortugues(), "Argélia");
	}
	
	@Test
	@Ignore
	public void encontraPaisPeloNomeSemAcentuacaoTest() {
		Pais pais = conversorDados.converterDadosDoJson(JSON_ALBANIA, Pais.class);
		paisRepository.save(pais);
		
		Pais pais2 = paisRepository.obtemPaisPeloNomeEmPortugues("Albania".toLowerCase());
		assertNotNull(pais2);
		assertEquals(pais2.getNomeSemAcentuacao(), "Albania");
	}
	
}
