package br.com.rodrigoeduque.cursomcnelioalves.categorias.model;

import java.util.Objects;

public class Categoria {

    private Long id;
    private String descricao;

    @Deprecated
    public Categoria() {
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id) && descricao.equals(categoria.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
