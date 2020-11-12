package br.com.senac.controller;

import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.vo.ClienteVO;


public class ClienteController {

	/*
	 * 	situacao = "AQUI VÃO SER TRABALHADOS OS CONTROLLERS - apenas testandooo";
		return situacao;
	 * 4 - Cliente deve possuir cadastro completo, sem nada em branco
	 * 5 - CPF deve ser válido 11 caracteres
	 * 
	 * 
	 */
	private ClienteBO bo = new ClienteBO();
		
	public String salvar(ClienteVO novoCliente) {
		String mensagem ="";
		
		if(validarNome(novoCliente) 
				&& validarSobrenome(novoCliente) 
				&& validarCpf(novoCliente)
				&& validarEmail(novoCliente) 
				&& validarCnh(novoCliente)
				&& validarTefone(novoCliente)
				&& validarEndereco(novoCliente)
				&& validarCidade(novoCliente)
				&& validarEstado(novoCliente)
				&& validarCep(novoCliente)){
			
			mensagem= "Cliente cadastrada com sucesso";
	}
		return mensagem;
}
	
	private boolean validarNome(ClienteVO novoCliente) {
		String mensagem ="";
		if(novoCliente.getNome().trim().length() < 3 
				|| novoCliente.getNome().isEmpty() ) {
			mensagem = "Nome deve conter ao menos três catacteres";
			return false;
		}
		return true;
	}

	private boolean validarCep(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarEstado(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarCidade(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarEndereco(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarTefone(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarCnh(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarEmail(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarCpf(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validarSobrenome(ClienteVO novoCliente) {
		// TODO Auto-generated method stub
		return false;
	}
		
	
}
