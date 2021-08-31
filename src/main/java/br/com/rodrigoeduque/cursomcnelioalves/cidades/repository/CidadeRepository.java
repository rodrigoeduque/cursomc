package br.com.rodrigoeduque.cursomcnelioalves.cidades.repository;

import br.com.rodrigoeduque.cursomcnelioalves.cidades.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
