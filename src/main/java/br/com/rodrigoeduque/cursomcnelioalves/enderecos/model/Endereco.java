package br.com.rodrigoeduque.cursomcnelioalves.enderecos.model;

import br.com.rodrigoeduque.cursomcnelioalves.cidades.model.Cidade;
import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @JsonIgnore
    @JoinColumn(name = "cliente_id")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "cidade_id")
    @ManyToOne
    private Cidade cidade;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String cep, Cliente cliente, Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cidade getCidade() {
        return cidade;
    }
}
