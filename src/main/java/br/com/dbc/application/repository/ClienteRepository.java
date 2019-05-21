package br.com.dbc.application.repository;

import br.com.dbc.application.entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
	public List<Cliente> findByCodigoCliente(Integer codigo);
	

}
