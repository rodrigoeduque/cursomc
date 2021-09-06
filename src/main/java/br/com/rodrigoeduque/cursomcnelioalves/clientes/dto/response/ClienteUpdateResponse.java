package br.com.rodrigoeduque.cursomcnelioalves.clientes.dto.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClienteUpdateResponse {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;

    public ClienteUpdateResponse(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
