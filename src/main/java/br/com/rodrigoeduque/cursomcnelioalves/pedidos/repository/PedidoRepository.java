package br.com.rodrigoeduque.cursomcnelioalves.pedidos.repository;

import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
