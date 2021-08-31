package br.com.rodrigoeduque.cursomcnelioalves.categorias.service;

import br.com.rodrigoeduque.cursomcnelioalves.exceptionhandler.exceptions.NaoEncontradaException;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria buscarPorId(Long id) {
        Optional<Categoria> possivelCategoria = repository.findById(id);
        return possivelCategoria.orElseThrow(() -> new NaoEncontradaException(" Categoria não encontrada : | " + id + " |"));
    }
}
