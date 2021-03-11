package com.livraria.dac2021.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import com.livraria.dac2021.model.Pedido;
import com.livraria.dac2021.repositories.PedidoRepository;

/**
 * 
 *
 */
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository; 
	
	public Pedido save (Pedido pedido) {
		return repository.save(pedido);
	}
	
	public void delete (Pedido pedido) {
		repository.delete(pedido);
	}
	
	public List<Pedido> findAll (){
		return repository.findAll();
	}
	
	public Pedido update (Pedido pedido) {
		return repository.save(pedido);
	}
	
	public Optional<Pedido> findByid(Integer id) {
		
		return repository.findById(id);
	}
	
	public Page<Pedido> findAllByPage (Integer number){
		Pageable page =  PageRequest.of(0, number, Sort.unsorted());
		return repository.findAll(page);
	}
}
