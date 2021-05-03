package com.livraria.dac2021.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	public Autor findByNome(String nome);
	public Page<Autor> findAllByOrderByNomeAsc(Pageable pagina);
	
	
}
