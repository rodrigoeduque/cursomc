package br.com.rodrigoeduque.cursomcnelioalves.clientes.controller;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response.ClienteResponse;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response.ClienteUpdateResponse;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response.EnderecoResponse;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {

        List<Cliente> lista = clienteService.listar();

        List<ClienteResponse> response = lista.stream()
                .map(cliente ->
                        new ClienteResponse(cliente.getNome(), cliente.getEmail(), cliente.getTipo().getDescricao(), cliente.getEnderecos(), cliente.getTelefones())
                ).collect(Collectors.toList());


        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Cliente cliente = clienteService.buscarPorId(id);

        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizar(@Valid @RequestBody ClienteUpdateResponse clienteUpdateResponse, @PathVariable Long id) {

        Cliente cliente = clienteService.toModel(clienteUpdateResponse);
        cliente.setId(id);

        cliente = clienteService.atualizar(clienteUpdateResponse);


        return ResponseEntity.noContent().build();
    }
}
