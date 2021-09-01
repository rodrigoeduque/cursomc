package br.com.rodrigoeduque.cursomcnelioalves.itempedido.repository;

import br.com.rodrigoeduque.cursomcnelioalves.itempedido.model.ItemPedido;
import br.com.rodrigoeduque.cursomcnelioalves.itempedido.model.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
