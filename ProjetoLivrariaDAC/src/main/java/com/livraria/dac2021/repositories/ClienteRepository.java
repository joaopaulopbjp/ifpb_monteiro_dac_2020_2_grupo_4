package com.livraria.dac2021.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.dac2021.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Optional<Cliente> findByEmail(String email);
	
}
