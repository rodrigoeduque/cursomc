package br.com.rodrigoeduque.cursomcnelioalves.categorias.dto;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @Length(min = 5, max = 20)
    private String nome;

    @Deprecated
    public CategoriaRequest() {
    }

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
