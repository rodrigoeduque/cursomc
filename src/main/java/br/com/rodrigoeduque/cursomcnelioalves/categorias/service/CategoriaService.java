package br.com.rodrigoeduque.cursomcnelioalves.categorias.service;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import br.com.rodrigoeduque.cursomcnelioalves.categorias.repository.CategoriaRepository;
import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.IntegridadeBancoDadosException;
import br.com.rodrigoeduque.cursomcnelioalves.utils.exceptionhandler.exceptions.NaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Categoria cadastrar(Categoria categoria) {
        Categoria novaCategoria = repository.save(categoria);

        return novaCategoria;
    }

    public Categoria atualizar(Categoria categoria) {

        buscarPorId(categoria.getId());


        return repository.save(categoria);
    }

    public void deletar(Long id) {
        Categoria categoria = buscarPorId(id);
        try {
            repository.delete(categoria);
        } catch (DataIntegrityViolationException exception) {
            throw new IntegridadeBancoDadosException("Não é possivel excluir essa categoria, pois a mesma esta vinculada a produtos");
        }
    }

    public List<Categoria> listar() {

        List<Categoria> todasCategorias = repository.findAll();

        return todasCategorias;
    }


    public Page<Categoria> buscaPorPagina(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return repository.findAll(pageRequest);
    }


}
