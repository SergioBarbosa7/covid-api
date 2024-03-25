package br.com.sergio.api.covid.repository;

import br.com.sergio.api.covid.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	@Query("select p from Pais p " +
			"where lower(p.nomeSemAcentuacao) = :nome " +
			"or lower(p.nomePortugues) = :nome")
	public Pais obtemPaisPeloNomeEmPortugues(@Param("nome") String nomeSemAcentuacao);
}
