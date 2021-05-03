package com.livraria.dac2021.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Pagamento;
import com.livraria.dac2021.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	@Autowired
	private PagamentoRepository repository;
	
	
	public Pagamento save(Pagamento pagamento) {
		return repository.save(pagamento);
	}
	
	
	public Pagamento update(Long codigo ,Pagamento pagamento) {
		Pagamento pagamentoRecuperado = repository.findById(codigo).get();
		BeanUtils.copyProperties(pagamento, pagamentoRecuperado,"id");
		repository.save(pagamentoRecuperado);
		return pagamentoRecuperado;
	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Pagamento PagamentofindById(long id) {
		Optional<Pagamento> Pagamento=repository.findById(id);
		return Pagamento.get();
	}
	
	
}
