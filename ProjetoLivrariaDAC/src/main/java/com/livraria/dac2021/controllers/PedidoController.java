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

import com.livraria.dac2021.model.Pedido;
import com.livraria.dac2021.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> save(@Valid @RequestBody Pedido pedido, HttpServletResponse response) {
		Pedido pedidoSalvo = pedidoService.save(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Pedido> update(@PathVariable Long codigo, @RequestBody Pedido pedido ) {
		Pedido pedidoSalva = pedidoService.update(codigo, pedido);
		return ResponseEntity.ok(pedidoSalva);
	}
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long codigo) {
		pedidoService.excluir(codigo);
	}
	@GetMapping("/{codigo}")
	public Pedido findById(long id) {
		return pedidoService.findById(id);
	}
	
	@GetMapping
	public Page<Pedido> findAll(Pageable page) {
		return pedidoService.findAll(page);
	}

}