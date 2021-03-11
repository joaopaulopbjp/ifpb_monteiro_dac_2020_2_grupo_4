package com.livraria.dac2021.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.dac2021.model.Livro;
/**
 * Repositório de livro onde foi criado os métodos para a consulta dos livros
 * em estoque e os que não estão em estoque usando o equals para saber os produtos
 * que não estão no estoque e o greather para saber quais produtos estão no estoque
 *
 */
public interface LivroRepository extends JpaRepository<Livro, Integer>{
	Page<Livro> findByEstoqueEquals (Integer estoque,Pageable pagina);
	Page<Livro> findByEstoqueGreaterThan(Integer estoque,Pageable pagina);
	List<Livro> findByEstoqueEquals (Integer estoque);
	List<Livro> findByEstoqueGreaterThan(Integer estoque);
	//recebo um integer para determinar se estou pesquisando os livros em estoque
	//ou os que estão no catálogo apenas
	List<Livro> findTop5LivrosByEstoqueGreaterThanOrderByPrecoDesc(Integer estoque);
 	
}
