package br.com.rodrigoeduque.cursomcnelioalves.categorias.dto;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;

public class CategoriaResponse {

    private Long id;
    private String nome;

    public CategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
