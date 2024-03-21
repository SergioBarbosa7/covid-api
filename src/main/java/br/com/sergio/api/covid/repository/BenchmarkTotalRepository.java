package br.com.sergio.api.covid.repository;

import br.com.sergio.api.covid.model.BenchmarkTotal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenchmarkTotalRepository extends JpaRepository<BenchmarkTotal, Long> {

}
