package com.livraria.dac2021.controllers;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.dac2021.model.Livro;
import com.livraria.dac2021.service.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService service;

	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody @Valid Livro book, HttpServletResponse response) {
		Livro livroSalvo = service.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
	}


	@PutMapping("/{codigo}")
	public ResponseEntity<Livro> update(@PathVariable Long codigo, @RequestBody Livro book) {
		Livro livroSalvo = service.update(codigo, book);
		return ResponseEntity.ok(livroSalvo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		service.delete(codigo);
	}

	@GetMapping("/baratos")
	public Page<Livro> getListaCincoMaisBaratos(Pageable page) {
		return service.findListaCincoMaisBaratos(page);
	}

	@GetMapping("/ordenados")
	public Page<Livro> findAllOrdenadoPorTitulo(Pageable page) {
		return service.findAllOrdenadoPorTitulo(page);
	}

	@GetMapping
	public Page<Livro> findAll(Pageable page) {
		return service.findAll(page);
	}
	
	
	
}
