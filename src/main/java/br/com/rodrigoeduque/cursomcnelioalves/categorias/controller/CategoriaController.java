package br.com.rodrigoeduque.cursomcnelioalves.categorias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @GetMapping
    public String listar() {
        return "REST Funcionando";
    }
}
