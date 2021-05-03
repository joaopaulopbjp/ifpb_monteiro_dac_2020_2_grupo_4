package com.livraria.dac2021.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.livraria.dac2021.model.Estoque;
import com.livraria.dac2021.model.Livro;
import com.livraria.dac2021.repositories.EstoqueRepository;
import com.livraria.dac2021.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	public Livro save(Livro livro) {
		Estoque estoque= livro.getEstoque();
		livro.setEstoque(null);
	
		livroRepository.save(livro);
	    Livro livroTemp = findByIsbn(livro.getIsbn());
	  
		estoque.setLivroid(livroTemp);
		estoqueRepository.save(estoque); 
		return livro;
	}
	
	public Livro update(Long codigo, Livro book) {
		Livro livroSalvo = findById(codigo);
		BeanUtils.copyProperties(book, livroSalvo, "id");
		livroRepository.save(livroSalvo);
		return livroSalvo;
	}
	
	public void delete(long id) {
		livroRepository.deleteById(id);
	}
	
	
	public Livro findByIsbn(String isbn) {
		Livro livroSalvo = livroRepository.findByIsbn(isbn);
		return livroSalvo!=null? livroSalvo:null;
	}
	
	public Livro findById(long id) {
		Livro livro = livroRepository.findById(id).get();
		return livro;
	}
	
	public Livro getBookPorNome(String nome){
		return livroRepository.findByTitulo(nome);
	}
	
	public Page<Livro> findAllOrdenadoPorTitulo(Pageable page){
        return livroRepository.findAllByOrderByTituloAsc(page);
	}
	
	public Page<Livro> findAllOrdenadoPorPreco(Pageable page){
        return livroRepository.findAllByOrderByPrecoAsc(page);
	}
	
	public Page<Livro> findListaCincoMaisBaratos(Pageable page){
        return estoqueRepository.findTop5ByOrderByLivroidAsc(page);
	}
	public Page<Livro> findAll(Pageable page){
		
        return livroRepository.findAll(page);
	}
}

