package com.livraria.dac2021.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Usuario;
import com.livraria.dac2021.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario update(Long codigo ,Usuario usuario) {
		Usuario usuarioSalvo = repository.findById(codigo).get();
		BeanUtils.copyProperties(usuario, usuarioSalvo,"id");
		repository.save(usuarioSalvo);
		return usuarioSalvo;	
		
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Usuario findById(long id) {
		Usuario usuario = repository.findById(id).get();
		return usuario;
	}
	
	
	
	public Usuario findByNome(String nome) {
		return repository.findByNome(nome);
	}

	public Page<Usuario> findAll(Pageable page) {
		return repository.findAll(page);
	}

	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}

	
	

}
