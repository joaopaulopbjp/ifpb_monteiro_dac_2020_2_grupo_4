package com.livraria.dac2021.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

/**
 *
 *Classe pojo de pedido
 */
@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date data;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="livro_pedido",
			joinColumns = @JoinColumn(name="idLivro"),inverseJoinColumns = @JoinColumn(name="idPedido"))
	private List<Livro> carrinho;
	@OneToOne
	private Cliente cliente;
	
	
	
	
	public Pedido(Integer id, Date data, List<Livro> carrinho, Cliente cliente) {
		
		this.id = id;
		this.data = data;
		this.carrinho = carrinho;
		this.cliente = cliente;
	}
	
	public Pedido() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Livro> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<Livro> carrinho) {
		this.carrinho = carrinho;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
