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

import com.livraria.dac2021.model.Estoque;
import com.livraria.dac2021.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService estoqueService;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Estoque> save(@Valid @RequestBody Estoque estoque, HttpServletResponse response) {
		Estoque estoqueSalvo = estoqueService.save(estoque);
		return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Estoque> update(@PathVariable Long codigo, @RequestBody Estoque estoque) {
		Estoque estoqueSalvo = estoqueService.update(codigo, estoque);
		return ResponseEntity.ok(estoqueSalvo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(long id) {
		estoqueService.delete(id);
	}
	
	public Estoque findById(long id) {
		return estoqueService.findById(id);
	}
	
	@GetMapping
	public Page<Estoque> findAll(Pageable page){
        return estoqueService.findAll(page);
	}
	
	@GetMapping("/findbaratos")
	public Page<Estoque> findBaratos(Pageable page){
        return estoqueService.getCincoMaisBaratosEstoque(page);
	}

}
