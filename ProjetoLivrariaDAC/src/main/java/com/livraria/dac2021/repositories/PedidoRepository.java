package com.livraria.dac2021.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
