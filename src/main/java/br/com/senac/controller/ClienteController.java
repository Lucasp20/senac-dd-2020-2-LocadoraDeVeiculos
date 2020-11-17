package br.com.senac.controller;

import java.util.List;

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
	/*private ClienteBO bo = new ClienteBO();*/
	
	/* public String salvar(ClienteVO cliente) {
		String situacao;
		situacao = "AQUI VÃO SER TRABALHADOS OS CONTROLLERS - apenas testandooo";
		cliente = bo.salvarCliente(cliente);
		return situacao; */
	private String mensagem ="";

	public String salvar(ClienteVO novoCliente) {
		
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
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.inserir(novoCliente);
			
			mensagem = "Cliente cadastrado com sucesso";

	}
		return mensagem;
}
	
	private boolean validarNome(ClienteVO novoCliente) {
		if(novoCliente.getNome().trim().length() < 3 
				|| novoCliente.getNome().isEmpty() ) {
			mensagem = "Nome deve conter ao menos três caracteres";
			return false;
		}
		return true;
	}
	
	private boolean validarSobrenome(ClienteVO novoCliente) {
		if(novoCliente.getSobrenome().trim().length() < 3 
				|| novoCliente.getSobrenome().isEmpty() ) {
			mensagem = "Sobrenome deve conter ao menos três caracteres";
			return false;
		}
		return true;
	}
	
	private boolean validarCpf(ClienteVO cpf) {
		if(cpf.getCpf().trim().length() != 11
				|| cpf.getCpf().isEmpty()) {
			
			mensagem = "CPF deve possuir tamanho 11 e somente números";
			return false;
		}
		return true;
	} 

	private boolean validarEmail(ClienteVO novoCliente) {
		if(novoCliente.getEmail().trim().length() < 3 
				|| novoCliente.getEmail().isEmpty() ) {
			mensagem = "Email deve conter ao menos três caracteres";
			return false;
		}
		return true;
	}

	private boolean validarCnh(ClienteVO cnh) {
		if(cnh.getCnh().trim().length() != 11
				|| cnh.getCnh().isEmpty()) {
			
			mensagem = "CNH deve possuir tamanho 11 e somente números";
			return false;
		}
		return true;
	} 
	
	private boolean validarCep(ClienteVO cep) {
		if(cep.getCep().trim().length() != 8
				|| cep.getCep().isEmpty()) {
			
			mensagem = "CPF deve possuir tamanho 11 e somente números";
			return false;
		}
		return true;
	} 
	
	private boolean validarTefone(ClienteVO telefone) {
		if(telefone.getTelefone().trim().length() != 11
				|| telefone.getTelefone().isEmpty()) {
			
			mensagem = "CPF deve possuir tamanho 11 e somente números";
			return false;
		}
		return true;
	} 
	
	private boolean validarEndereco(ClienteVO novoCliente) {
		if(novoCliente.getEndereco().trim().length() < 3 
				|| novoCliente.getEndereco().isEmpty() ) {
			mensagem = "Endereco deve conter ao menos três caracteres";
			return false;
		}
		return true;
	}
	
	private boolean validarCidade(ClienteVO novoCliente) {
		if(novoCliente.getCidade().trim().length() < 3 
				|| novoCliente.getCidade().isEmpty() ) {
			mensagem = "Cidade deve conter ao menos três caracteres";
			return false;
		}
		return true;
	}

	private boolean validarEstado(ClienteVO novoCliente) {
		if(novoCliente.getEstado().isEmpty() ) {
			mensagem = "Deve preencher o campo estado";
			return false;
		}
		return true;
	}

	public String gerarPlanilha(List<ClienteVO> dadosConsultados, String caminho) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
