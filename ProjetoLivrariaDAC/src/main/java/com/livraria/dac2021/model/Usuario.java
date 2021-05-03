/**
 * 
 */
package com.livraria.dac2021.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;


@Entity
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	@NotNull
	private String email;
	@NotNull
	private String senha;
	@NotNull
	private String nome;
	@NotNull
	@Column(unique=true)
	private String cpf;
	private String endereco;
	private String cep;
	private String telefone;
	@Enumerated
	private TipoUsuario tipoUsuario;
	
	
	
	
	
	
	

}
