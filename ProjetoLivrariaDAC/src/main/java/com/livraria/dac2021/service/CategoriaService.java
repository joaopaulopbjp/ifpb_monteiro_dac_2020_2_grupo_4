package com.livraria.dac2021.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Categoria;
import com.livraria.dac2021.repositories.CategoriaRepository;

import javassist.NotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria save (Categoria autor) {
		return repository.save(autor);
	}
	public  Categoria update(Long codigo, Categoria categoria)  {
		Categoria categoriaRecuperada = findById(codigo);
		BeanUtils.copyProperties(categoria, categoriaRecuperada,"id");
		repository.save(categoriaRecuperada);
		return categoriaRecuperada;	
	}

	public Categoria findById(Long codigo)  {
		Categoria categoriaRecuperada = repository.findById(codigo).get();
		
		return categoriaRecuperada;
	}
	
	
	public void delete(long id)  {
		findById(id);
		repository.deleteById(id);
	}
	
	
	
	public Categoria findAutorByNome(String nome){
		return repository.findByNome(nome);
	}
	
	public Page<Categoria> findAll(Pageable page){
        return repository.findAllByOrderByNomeAsc(page);
	}

}
