package br.com.rodrigoeduque.cursomcnelioalves.clientes.service;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.repository.ClienteRepository;
import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.NaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente buscarPorId(Long id) {

        Optional<Cliente> possivelCliente = repository.findById(id);

        return possivelCliente.orElseThrow(() -> new NaoEncontradaException(" Cliente não encontrado : | " + id + " |"));

    }
}
