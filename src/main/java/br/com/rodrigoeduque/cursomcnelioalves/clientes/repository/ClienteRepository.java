package br.com.rodrigoeduque.cursomcnelioalves.clientes.repository;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
