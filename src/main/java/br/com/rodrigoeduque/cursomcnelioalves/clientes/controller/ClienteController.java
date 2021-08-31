package br.com.rodrigoeduque.cursomcnelioalves.clientes.controller;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Cliente cliente = clienteService.buscarPorId(id);

        return ResponseEntity.ok().body(cliente);
    }
}
