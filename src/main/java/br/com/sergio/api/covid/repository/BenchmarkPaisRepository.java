package br.com.sergio.api.covid.repository;

import br.com.sergio.api.covid.model.BenchmarkPais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchmarkPaisRepository extends JpaRepository<BenchmarkPais, Long> {

}
