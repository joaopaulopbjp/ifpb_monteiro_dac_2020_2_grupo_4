package com.livraria.dac2021.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Estoque;
import com.livraria.dac2021.repositories.EstoqueRepository;

import javassist.NotFoundException;

@Service
public class EstoqueService {
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public Estoque save( Estoque estoque) {
		return estoqueRepository.save(estoque);
		
	}
	
	public Estoque update(long codigo, Estoque estoque) {
		Estoque estoqueSalvo = estoqueRepository.findById(codigo).get();
		BeanUtils.copyProperties(estoque, estoqueSalvo, "id");
		estoqueRepository.save(estoque);
		return estoqueSalvo;
	}

	public void delete(long id)  {
		findById(id);
		estoqueRepository.deleteById(id);
	}
	
	
	
	
	public Estoque findById(long id) {
		Estoque estoque =estoqueRepository.findById(id).get();
		
		return estoque;
	}
	
	public Page<Estoque> findAll(Pageable page){
        return estoqueRepository.findAll(page);
	}
	
	public Page<Estoque> getCincoMaisBaratosEstoque(Pageable page){
        return estoqueRepository.findAll(page);
	}

}
