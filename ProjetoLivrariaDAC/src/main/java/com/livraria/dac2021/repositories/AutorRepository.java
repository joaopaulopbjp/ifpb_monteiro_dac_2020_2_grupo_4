package com.livraria.dac2021.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.dac2021.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
