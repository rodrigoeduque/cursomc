package br.com.rodrigoeduque.cursomcnelioalves.pedidos.services;

import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;
import br.com.rodrigoeduque.cursomcnelioalves.pedidos.repository.PedidoRepository;
import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.NaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository repository;

    @Autowired
    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido findById(Long id) {
        Optional<Pedido> possivelPedido = repository.findById(id);
        return possivelPedido.orElseThrow(() -> new NaoEncontradaException(" Categoria não encontrada : | " + id + " |"));
    }
}
