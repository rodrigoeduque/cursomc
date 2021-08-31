package br.com.rodrigoeduque.cursomcnelioalves.pagamentos;

import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
