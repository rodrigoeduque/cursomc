package br.com.rodrigoeduque.cursomcnelioalves.pagamentos.model;

import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;

    public PagamentoComBoleto(){

    }

    public PagamentoComBoleto(EstadoPagamento estado, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }


}
