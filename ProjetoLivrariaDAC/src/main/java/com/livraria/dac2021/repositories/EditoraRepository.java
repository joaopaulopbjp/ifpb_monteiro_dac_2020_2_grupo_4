package com.livraria.dac2021.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
	public Page<Editora> findAllByOrderByNomeAsc(Pageable pagina);

	public Editora findByCNPJ(String cnpj);

	public Editora findByNome(String nome);
	
}
