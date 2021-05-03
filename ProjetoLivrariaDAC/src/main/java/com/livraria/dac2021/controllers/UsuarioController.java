package com.livraria.dac2021.controllers;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.dac2021.model.Usuario;
import com.livraria.dac2021.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioService service; 
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = service.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> update(@PathVariable Long codigo, @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = service.update(codigo, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long codigo) {
		service.delete(codigo);
	}

	@GetMapping("/{codigo}")
	public Usuario findById(long codigo) {
		Usuario usuario=service.findById(codigo);
		return usuario;
	}
	@GetMapping("/findbyname/{nome}")
	public Usuario findByNome(String nome) {
		return service.findByNome(nome);
	}
	@GetMapping
	public Page<Usuario> findAll(Pageable page) {
		return service.findAll(page);
	}
	@GetMapping("/findbyemail/{email}")
	public Usuario getUsuarioPorEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
	
	
}
