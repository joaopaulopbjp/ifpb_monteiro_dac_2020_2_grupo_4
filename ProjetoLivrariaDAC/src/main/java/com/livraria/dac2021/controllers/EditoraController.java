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

import com.livraria.dac2021.model.Editora;
import com.livraria.dac2021.service.EditoraService;

@RestController
@RequestMapping("/editora")
public class EditoraController {
	
	@Autowired
	private EditoraService service;
	
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Editora> save(@Valid @RequestBody Editora editora, HttpServletResponse response) {
		Editora editoraSalvo = service.save(editora);
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Editora> update(@PathVariable Long codigo, @RequestBody Editora editora) {
		Editora EditoraSalvo = service.update(codigo, editora);
		return ResponseEntity.ok(EditoraSalvo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long codigo) {
		service.delete(codigo);
	}
	@GetMapping("/{codigo}")
	public Editora findById(long codigo) {
		Editora editora=service.findById(codigo);
		return editora;
	}
	@GetMapping("/buscanome/{nome}")
	public Editora findBynome(@PathVariable String nome ){
		return service.findByName(nome);
	}
	
	@GetMapping
	public Page<Editora> findAll(Pageable page){
		return service.findAll(page);
	}
	
	

}
