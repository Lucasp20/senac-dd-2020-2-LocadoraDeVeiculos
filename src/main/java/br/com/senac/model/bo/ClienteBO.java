package br.com.senac.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.controller.ClienteController;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.vo.ClienteVO;

public class ClienteBO {

	ClienteController clienteController = new ClienteController();


	public String cadastrarCliente(ClienteVO novoCliente) {
		return clienteController.cadastrarCliente(novoCliente);
	}

	public boolean atualizarCliente(ClienteVO novoCliente) {
		return clienteController.atualizarCliente(novoCliente);
	}
	
	public String excluirCliente(ClienteVO clienteExcluido) {
		return clienteController.excluirCliente(clienteExcluido);
	}
	
	public List<ClienteVO> listarClientesFiltro(ClienteSeletor seletor){
		return clienteController.listarClientesFiltro(seletor);
	}
	
}
