package com.livraria.dac2021.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Data
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="livro_pedido",
			joinColumns = @JoinColumn(name="idLivro"),inverseJoinColumns = @JoinColumn(name="idPedido"))
	private List<Livro> carrinho;
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cliente;
	@Enumerated
	private StatusPedido status;
	private Double valor;
	@OneToOne
	@JoinColumn(name = "pagamento")
	private Pagamento pagamento;
	
	
	
	@PrePersist
	private void dataCriacao() {
		this.data = new Date();
	}
	
	
	
	
	

}
