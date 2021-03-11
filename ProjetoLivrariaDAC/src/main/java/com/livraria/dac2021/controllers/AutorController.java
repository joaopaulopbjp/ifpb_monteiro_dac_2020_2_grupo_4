package com.livraria.dac2021.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.livraria.dac2021.model.Autor;
import com.livraria.dac2021.repositories.AutorRepository;

/**
 * 
 *
 */
@Controller
public class AutorController {

	
	@Autowired
	private AutorRepository repository;
	
	public Autor save (Autor autor) {
		return repository.save(autor);
	}
	
	public void delete (Autor autor) {
		repository.delete(autor);
	}
	
	public List<Autor> findAll (){
		return repository.findAll();
	}
	
	public Autor update (Autor autor) {
		return repository.save(autor);
	}
	
	public Optional<Autor> findById(Integer id) {
		
		return repository.findById(id);
	}
	
}
