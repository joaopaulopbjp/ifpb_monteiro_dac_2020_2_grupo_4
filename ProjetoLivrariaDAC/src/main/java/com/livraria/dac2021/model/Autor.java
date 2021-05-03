/**
 * 
 */
package com.livraria.dac2021.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * 
 * Classe de pojo de autor
 */
@Entity
@Data
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nacionalidade;
	private String biografia;
	private String foto;
	@ManyToMany(mappedBy = "autores")
	private List<Livro>listLivro;
	
	
	
	
	
	
	
	
	
	

}
