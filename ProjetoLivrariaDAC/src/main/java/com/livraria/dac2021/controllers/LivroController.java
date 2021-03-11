package com.livraria.dac2021.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.livraria.dac2021.model.Livro;
import com.livraria.dac2021.repositories.LivroRepository;

/**
 * 
 *
 */
@Controller
public class LivroController {

	@Autowired
	private LivroRepository repository; 
	
	public Livro save (Livro livro) {
		return repository.save(livro);
	}
	
	public void delete (Livro livro) {
		repository.delete(livro);
	}
	
	public List<Livro> findAll (){
		return repository.findAll();
	}
	
	public Livro update (Livro livro) {
		return repository.save(livro);
	}
	
	public Optional<Livro> findById(Integer id) {
		
		return repository.findById(id);
	}
	
	public List<Livro> findCheapers (){
		return repository.findTop5LivrosByEstoqueGreaterThanOrderByPrecoDesc(1);
	}
	
	public Page<Livro> findAllByPage (Integer pag){
		Pageable page =  PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC,"titulo"));
		return repository.findAll(page);
	}
	
	public Page<Livro> findAllByPageInEstoque(Integer pag){
		Pageable page =  PageRequest.of(pag, 5, Sort.by(Sort.Direction.ASC,"titulo"));
		return repository.findByEstoqueGreaterThan(1, page);
	}
	
	public Page<Livro> findAllByPageNotInEstoque(Integer pag){
		Pageable page =  PageRequest.of(pag, 5, Sort.by(Sort.Direction.ASC,"titulo"));
		return repository.findByEstoqueEquals(0, page);
	}
	
}
