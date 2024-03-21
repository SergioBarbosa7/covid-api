package br.com.sergio.api.covid.repository;

import br.com.sergio.api.covid.model.BenchmarkTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchmarkTotalRepository extends JpaRepository<BenchmarkTotal, Long> {

}
