package com.livraria.dac2021.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Autor;
import com.livraria.dac2021.repositories.AutorRepository;


@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	public Autor save (Autor autor) {
		return repository.save(autor);
	}
	public  Autor update(Long codigo, Autor autor)  {
		Autor autorSalvo = findById(codigo);
		BeanUtils.copyProperties(autor, autorSalvo,"id");
		repository.save(autorSalvo);
		return autorSalvo;	
	}

	public Autor findById(Long codigo) {
		Autor autorSalvo = repository.findById(codigo).get();
		return autorSalvo;
	}
	
	
	public void delete(long id)  {
		findById(id);
		repository.deleteById(id);
	}
	
	
	
	public Autor findAutorByNome(String nome){
		return repository.findByNome(nome);
	}
	
	public Page<Autor> findAll(Pageable page){
        return repository.findAllByOrderByNomeAsc(page);
	}
	
}
