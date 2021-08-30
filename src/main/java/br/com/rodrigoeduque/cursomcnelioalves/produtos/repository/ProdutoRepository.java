package br.com.rodrigoeduque.cursomcnelioalves.produtos.repository;

import br.com.rodrigoeduque.cursomcnelioalves.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
