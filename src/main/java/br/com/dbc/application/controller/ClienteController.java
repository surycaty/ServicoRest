package br.com.dbc.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.application.entity.Cliente;
import br.com.dbc.application.service.ClienteService;
import br.com.dbc.application.to.EmprestimoTO;
import br.com.dbc.application.util.Resultado;
import br.com.dbc.application.util.Util;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Autowired
	private Resultado resultado;

//		/**
//		 * Chama a view (simulador.jsp) para editar um registro cadastrado
//		 * 
//		 */
//		@RequestMapping(value = "/simulador.html/{codigo}", method = RequestMethod.GET)
//		public ModelAndView simulador(@PathVariable int codigo) {
//
//			Cliente cliente = repository.consultarPorCodigo(codigo);
//			
//			return new ModelAndView("simulador", "cliente", cliente);
//		}

	/**
	 * Consultar todos os registros cadastrados
	 * 
	 * @return
	 */
	@GetMapping(path = "/listar")
	public @ResponseBody List<Cliente> listarTodos() {
		return service.listarClientes();
	}

	/**
	 * Salvar um novo registro
	 * 
	 * @param cliente
	 * @return
	 */
	@PostMapping(path = "/salvar")
	public @ResponseBody Resultado salvar(@RequestBody Cliente cliente) {

		try {

			service.salvar(cliente);

			resultado.setCodigo(1);
			resultado.setMensagem("Registro inserido com sucesso!");

		} catch (Exception e) {

			resultado.setCodigo(2);
			resultado.setMensagem("Erro ao salvar o registro (" + e.getMessage() + ")");
		}

		return resultado;
	}

	/**
	 * Alterar um registro cadastrado
	 * 
	 * @param cliente
	 * @return
	 */
	@PutMapping(path = "/alterar")
	public @ResponseBody Resultado alterar(@RequestBody Cliente cliente) {

		try {

			service.alterar(cliente);

			resultado.setCodigo(1);
			resultado.setMensagem("Registro alterado com sucesso!");
			
		} catch (Exception e) {

			resultado.setCodigo(2);
			resultado.setMensagem("Erro ao salvar o registro (" + e.getMessage() + ")");
		}

		return resultado;
	}

	/**
	 * Excluir um cliente pelo código
	 * 
	 * @param codigo
	 */
	@DeleteMapping(path = "excluir/{codigo}")
	public @ResponseBody Resultado excluir(@PathVariable int codigo) {
		
		try {
			
			service.excluir(codigo);
			
			resultado.setCodigo(1);
			resultado.setMensagem("Registro Excluido com sucesso!");
			
		} catch (Exception e) {

			resultado.setCodigo(2);
			resultado.setMensagem("Erro ao Excluir o registro (" + e.getMessage() + ")");
		}
		
		return resultado;
	}

	/**
	 * Calcular valor de emprestimo
	 * 
	 * @param emprestimo
	 * @return
	 */
	@PostMapping(path = "/calcular")
	public @ResponseBody EmprestimoTO calcular(@RequestBody EmprestimoTO emprestimo) {
		return Util.calcularEmprestimo(emprestimo);
	}

}
