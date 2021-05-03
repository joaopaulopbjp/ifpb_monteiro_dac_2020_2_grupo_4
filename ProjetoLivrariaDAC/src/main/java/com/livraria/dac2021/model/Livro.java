package com.livraria.dac2021.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Data;


@Data
@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@Column(unique = true)
	private String isbn;
	private String descricao;
	private String imagem;
	private Double preco;
	private String edicao;
	@OneToOne
	@JoinColumn(name = "editoraId")
	private Editora editora;
	@OneToOne
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@OneToOne(mappedBy = "livroid")
	private Estoque estoque;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="livro_autor",
	joinColumns = @JoinColumn(name="idLivro"),inverseJoinColumns = @JoinColumn(name="idAutor"))
	private List<Autor> autores;
	@Temporal(TemporalType.DATE)
	private Date lancamento;
	
	
	
	
	
	
	
	

}
