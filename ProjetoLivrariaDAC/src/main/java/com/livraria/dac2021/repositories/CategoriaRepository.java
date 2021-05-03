package com.livraria.dac2021.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public Page<Categoria> findAllByOrderByNomeAsc(Pageable pagina);
	public Categoria findByNome(String nome);

}
