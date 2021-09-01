package br.com.rodrigoeduque.cursomcnelioalves.pedidos.controller;

import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;
import br.com.rodrigoeduque.cursomcnelioalves.pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);

        return ResponseEntity.ok().body(pedido);
    }
}
