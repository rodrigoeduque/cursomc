package br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model;

import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {
    private Integer numerosDeParcelas;

    public PagamentoComCartao() {

    }

    public PagamentoComCartao(EstadoPagamento estado, Pedido pedido, Integer numerosDeParcelas) {
        super(estado, pedido);
        this.numerosDeParcelas = numerosDeParcelas;
    }

    public Integer getNumerosDeParcelas() {
        return numerosDeParcelas;
    }
}
