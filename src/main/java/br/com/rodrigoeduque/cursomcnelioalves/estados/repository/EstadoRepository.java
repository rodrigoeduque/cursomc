package br.com.rodrigoeduque.cursomcnelioalves.estados.repository;

import br.com.rodrigoeduque.cursomcnelioalves.estados.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
