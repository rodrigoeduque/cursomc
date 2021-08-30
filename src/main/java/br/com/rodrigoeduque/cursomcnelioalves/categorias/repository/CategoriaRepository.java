package br.com.rodrigoeduque.cursomcnelioalves.categorias.repository;

import br.com.rodrigoeduque.cursomcnelioalves.categorias.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
