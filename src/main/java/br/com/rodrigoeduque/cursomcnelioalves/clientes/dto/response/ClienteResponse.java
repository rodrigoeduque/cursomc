package br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.enderecos.model.Endereco;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteResponse {

    private String nome;
    private String email;
    private String tipo;
    private List<Endereco> enderecos;
    private Set<String> telefones;

    @Deprecated
    public ClienteResponse() {
    }

    public ClienteResponse(String nome, String email, String tipo, List<Endereco> enderecos, Set<String> telefones) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }
}
