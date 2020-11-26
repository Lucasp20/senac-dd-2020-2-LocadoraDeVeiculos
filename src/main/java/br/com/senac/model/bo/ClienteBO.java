package br.com.senac.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.controller.ClienteController;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.vo.ClienteVO;

public class ClienteBO {

	private ClienteDAO clienteDAO = new ClienteDAO();

	/*
	 * public boolean salvarCliente(ClienteVO novoCliente) { boolean salvou = false;
	 * int chaveGerada = this.clienteDAO.inserir(novoCliente);
	 * 
	 * salvou = (chaveGerada > 0);
	 * 
	 * return salvou;
	 */

	public String cadastrarCliente(ClienteVO novoCliente) {
		ClienteController clienteController = new ClienteController();
		return clienteController.cadastrarCliente(novoCliente);
	}

	public boolean atualizarCliente(ClienteVO novoCliente) {
		ClienteController clienteController = new ClienteController();
		return clienteController.atualizarCliente(novoCliente);
	}
}
