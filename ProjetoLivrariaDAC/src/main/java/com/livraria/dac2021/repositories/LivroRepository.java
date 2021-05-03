package com.livraria.dac2021.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Livro;
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	public Livro findByTitulo(String titulo);
	public Page <Livro> findAllByOrderByTituloAsc(Pageable page);
	public Page <Livro> findAllByOrderByPrecoAsc(Pageable page);
	public Livro findByIsbn(String ISBN);

 	
}
