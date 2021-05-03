package com.livraria.dac2021.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Estoque;
import com.livraria.dac2021.model.Livro;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	Page<Livro> findTop5ByOrderByLivroidAsc(Pageable page);
}
