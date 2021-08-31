package br.com.rodrigoeduque.cursomcnelioalves.pedidos.model;

import br.com.rodrigoeduque.cursomcnelioalves.clientes.model.Cliente;
import br.com.rodrigoeduque.cursomcnelioalves.enderecos.model.Endereco;
import br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model.Pagamento;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime instante = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @JoinColumn(name = "cliente_id")
    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "enderecoEntregaId")
    private Endereco enderecoDeEntrega;

    @Deprecated
    public Pedido() {
    }

    public Pedido(Cliente cliente, Endereco enderecoDeEntrega) {
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
