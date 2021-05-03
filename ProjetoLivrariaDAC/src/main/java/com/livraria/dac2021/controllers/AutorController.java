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

import com.livraria.dac2021.model.Autor;
import com.livraria.dac2021.service.AutorService;


@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	AutorService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Autor> save(@Valid @RequestBody Autor autor, HttpServletResponse response) {
		Autor autorSalvo = service.save(autor);
		return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Autor> update(@PathVariable Long codigo, @RequestBody Autor autor) {
		Autor autorSalvo = service.update(codigo, autor);
		return ResponseEntity.ok(autorSalvo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		service.delete(codigo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Autor> findById(@PathVariable Long codigo) {
		Autor autor = service.findById(codigo);
		return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
	}

	@GetMapping("/findnome/{nome}")
	public ResponseEntity<Autor> getAutorPorNome(@PathVariable String nome) {
		Autor autor = service.findAutorByNome(nome);
		return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public Page<Autor> findAll(Pageable page) {
		return service.findAll(null);
	}
	
}
