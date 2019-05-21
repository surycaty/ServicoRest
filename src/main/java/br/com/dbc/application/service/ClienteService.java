package br.com.dbc.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.dbc.application.entity.Cliente;
import br.com.dbc.application.repository.ClienteRepository;
import javassist.NotFoundException;

@Controller
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	
	public List<Cliente> listarTodos() {
		return repository.findAll();
	}
	
	public void salvar(Cliente cliente) {
		repository.save(cliente);
	}
	
	public void alterar(Cliente cliente) throws Exception {
		
		Cliente clienteAlterar = repository.getOne(cliente.getCodigoCliente());
		
		if(clienteAlterar != null) {
			repository.saveAndFlush(cliente);
			return;
		}
				
		throw new NotFoundException("Cliente não existe");
		
	}

	public List<Cliente> listarClientes() {
		return repository.findAll();
	}

	public void excluir(Integer codigo) {
		repository.deleteById(codigo);
	}

}
