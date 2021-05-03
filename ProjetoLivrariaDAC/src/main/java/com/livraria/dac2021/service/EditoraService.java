package com.livraria.dac2021.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Editora;
import com.livraria.dac2021.repositories.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	private EditoraRepository repository;

	public Editora save(Editora editora) {
		return repository.save(editora);
	}
	
	public Editora update(Long codigo, Editora editora) {
		Editora editoraRecuperada = repository.findById(codigo).get();
		BeanUtils.copyProperties(editora, editoraRecuperada, "id");
		repository.save(editoraRecuperada);
		return editoraRecuperada;
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Editora findById(long id) {
		Editora editora=repository.findById(id).get();
		return editora;
	}
	
	
	public Editora findByCNPJ(String cnpj) {
		Editora editora=repository.findByCNPJ(cnpj);
		return editora;
	}
	public Editora findByName(String nome) {
		return repository.findByNome(nome);
	}	
	public Page<Editora> findAll(Pageable page){
		return repository.findAll(page);
	}

}
