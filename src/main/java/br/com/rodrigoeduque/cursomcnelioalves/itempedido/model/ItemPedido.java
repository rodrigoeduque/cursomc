package br.com.rodrigoeduque.cursomcnelioalves.itempedido.model;

import br.com.rodrigoeduque.cursomcnelioalves.pedidos.model.Pedido;
import br.com.rodrigoeduque.cursomcnelioalves.produtos.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class ItemPedido {

    @EmbeddedId
    @JsonIgnore
    private ItemPedidoPK id = new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    @Deprecated
    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    @JsonIgnore
    public Produto getProduto() {
        return id.getProduto();
    }

}
