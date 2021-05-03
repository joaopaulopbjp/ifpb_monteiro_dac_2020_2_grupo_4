package com.livraria.dac2021.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.livraria.dac2021.model.Cliente;
import com.livraria.dac2021.repositories.ClienteRepository;

/**
 * 
 *
 */
@Controller
public class ClienteController {

	
	@Autowired
	private ClienteRepository repository; 
	
	public Cliente save (Cliente cliente) {
		return repository.save(cliente);
	}
	
	public void delete (Cliente cliente) {
		repository.delete(cliente);
	}
	
	public List<Cliente> findAll (){
		return repository.findAll();
	}
	
	public Cliente update (Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Optional<Cliente> findByEmail(String email){
		return repository.findByEmail(email);
	}
	
	public Optional<Cliente> findByid(Integer id) {
		
		return repository.findById(id);
	}
	
	public Page<Cliente> findAllByPage (Integer number){
		Pageable page =  PageRequest.of(0, number, Sort.unsorted());
		return repository.findAll(page);
	}
	
}
