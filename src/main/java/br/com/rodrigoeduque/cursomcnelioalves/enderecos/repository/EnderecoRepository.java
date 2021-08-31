package br.com.rodrigoeduque.cursomcnelioalves.enderecos.repository;

import br.com.rodrigoeduque.cursomcnelioalves.enderecos.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
