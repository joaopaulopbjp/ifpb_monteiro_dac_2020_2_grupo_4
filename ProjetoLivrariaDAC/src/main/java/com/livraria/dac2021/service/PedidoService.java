package com.livraria.dac2021.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Pedido;
import com.livraria.dac2021.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	

	public Pedido save(Pedido pedido) {

		
		return repository.save(pedido);

	}

	public Pedido update(Long codigo, Pedido pedido) {
		Pedido pedidoSalvo = repository.findById(codigo).get();
		BeanUtils.copyProperties(pedido, pedidoSalvo, "id");
		repository.save(pedido);
		return pedidoSalvo;

	}

	public void excluir(long id) {
		repository.deleteById(id);
	}

	public Pedido findById(long id) {
		Pedido pedido = repository.findById(id).get();
		return pedido;
	}

	public Page<Pedido> findAll(Pageable page) {
		return repository.findAll(page);
	}

}
