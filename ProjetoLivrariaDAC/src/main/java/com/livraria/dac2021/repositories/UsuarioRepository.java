package com.livraria.dac2021.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livraria.dac2021.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByEmail(String email);
	public Usuario findByNome(String nome);
	public Usuario findByCpf(String cpf);
	
}
