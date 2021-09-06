package br.com.rodrigoeduque.cursomcnelioalves.categorias.controller;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.dto.CategoriaRequest;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.dto.CategoriaResponse;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar() {

        List<Categoria> categorias = service.listar();

        List<CategoriaResponse> response = categorias.stream().map(categoria -> new CategoriaResponse(categoria)).collect(Collectors.toList());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CategoriaResponse>> buscarPorPagina(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                   @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                                   @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
                                                                   @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Categoria> categoriaPage = service.buscaPorPagina(page, linesPerPage, orderBy, direction);

        Page<CategoriaResponse> categoriaResponses = categoriaPage.map(cat -> new CategoriaResponse(cat));

        return ResponseEntity.ok().body(categoriaResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscaPorId(@PathVariable Long id) {

        Categoria categoria = service.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody CategoriaRequest request) {

        Categoria cat = request.toModel();
        Categoria novaCategoria = service.cadastrar(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCategoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody Categoria categoria, @PathVariable Long id) {
        categoria.setId(id);
        categoria = service.atualizar(categoria);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
