package br.com.sergio.api.covid.external.handler;

import br.com.sergio.api.covid.external.ExternalDadosPorDia;
import br.com.sergio.api.covid.external.EnvelopeDadosPorPaisJson;
import br.com.sergio.api.covid.external.ListaEnvelopesDadosPorPaisJson;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Set;

@Component
public class ExternalDadosPaisesHandler {
	
	public EnvelopeDadosPorPaisJson trataPaisesComRegioes(ListaEnvelopesDadosPorPaisJson lista) {
		EnvelopeDadosPorPaisJson envelopeBase = lista.get(0);
		Map<String, ExternalDadosPorDia> mapBase = envelopeBase.getMapDataParaDados();
		for (int i = 1; i < lista.size(); i++) {
			Map<String, ExternalDadosPorDia> mapComplementar = lista.get(i).getMapDataParaDados();
			somaMaps(mapBase, mapComplementar);
		}
		envelopeBase.setMapDataParaDados(mapBase);
		return envelopeBase;
	}
	
	public void somaMaps(Map<String, ExternalDadosPorDia> mapBase, Map<String, ExternalDadosPorDia> mapComplementar) {
		Set<String> chaves = mapBase.keySet();
		for (String chave : chaves) {
			ExternalDadosPorDia dadosPorDia = mapComplementar.get(chave);
			if (dadosPorDia != null) {
				mapBase.get(chave).adicionaAoTotal(dadosPorDia.getTotal());
				mapBase.get(chave).adicionaAosNovos(dadosPorDia.getNovos());
			}
		}
	}
}
