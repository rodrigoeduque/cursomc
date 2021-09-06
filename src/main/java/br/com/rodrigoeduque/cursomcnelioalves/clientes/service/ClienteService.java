package br.com.rodrigoeduque.cursomcnelioalves.clientes.service;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response.ClienteUpdateResponse;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response.EnderecoResponse;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.repository.ClienteRepository;
import br.com.rodrigoeduque.cursomcnelioalves.enderecos.model.Endereco;
import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.NaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Cliente> listar() {
        List<Cliente> todos = repository.findAll();

        return todos;
    }

    public List<EnderecoResponse> toEnderecoResponse(Endereco endereco) {

        List<EnderecoResponse> enderecoResponses = (List<EnderecoResponse>) new EnderecoResponse(endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade().toString(),
                endereco.getCidade().getEstado().toString());

        return enderecoResponses;
    }

    public Cliente toModel(ClienteUpdateResponse clienteUpdateResponse) {
        return new Cliente(clienteUpdateResponse.getNome(), clienteUpdateResponse.getEmail(), null, null);
    }

    public Cliente atualizar(Cliente cliente) {
        Cliente c1 = repository.findById(cliente.getId()).get();
        c1.atttData()

    }
}
