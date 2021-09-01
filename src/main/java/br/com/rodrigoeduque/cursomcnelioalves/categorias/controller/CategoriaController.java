package br.com.rodrigoeduque.cursomcnelioalves.categorias.controller;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {

        Categoria categoria = service.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = service.cadastrar(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
