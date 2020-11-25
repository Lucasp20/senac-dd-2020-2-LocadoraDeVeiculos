package br.com.senac.controller;

import java.util.List;

import javax.swing.JFormattedTextField;

import br.com.senac.constante.Mensagens;
import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.vo.ClienteVO;


public class ClienteController {
	
	private ClienteDAO clienteDAO;

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

	public String cadastrarCliente(ClienteVO novoCliente) {
		
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
			
			mensagem = Mensagens.CLIENTE_SUCESSO;

	}
		return mensagem;
	}
	
	private boolean validarNome(ClienteVO novoCliente) {
		if(novoCliente.getNome().trim().length() < 3 
				|| novoCliente.getNome().isEmpty() ) {
			mensagem = Mensagens.CLIENTE_ERRO_NOME;
			return false;
		}
		return true;
	}
	
	private boolean validarSobrenome(ClienteVO novoCliente) {
		if(novoCliente.getSobrenome().trim().length() < 3 
				|| novoCliente.getSobrenome().isEmpty() ) {
			mensagem = Mensagens.CLIENTE_ERRO_SOBRENOME;
			return false;
		}
		return true;
	}
	
	private boolean validarCpf(ClienteVO cpf) {
		if( cpf.getCpf().length() < 11
			|| cpf.getCpf().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_CPF;
			return false;
		}
		return true;
	} 

	private boolean validarEmail(ClienteVO novoCliente) {
		if(novoCliente.getEmail().trim().length() < 3 
				|| novoCliente.getEmail().isEmpty() ) {
			mensagem = Mensagens.CLIENTE_ERRO_EMAIL;
			return false;
		}
		return true;
	}

	private boolean validarCnh(ClienteVO cnh) {
		if(cnh.getCnh().trim().length() != 11
				|| cnh.getCnh().isEmpty()) {
			
			mensagem = Mensagens.CLIENTE_ERRO_CNH;
			return false;
		}
		return true;
	} 
		
	private boolean validarTefone(ClienteVO telefone) {
		if(telefone.getTelefone().trim().length() != 14
				|| telefone.getTelefone().isEmpty()) {
			
			mensagem = Mensagens.CLIENTE_ERRO_TELFONE;
			return false;
		}
		return true;
	} 
	
	private boolean validarEndereco(ClienteVO novoCliente) {
		if(novoCliente.getEndereco().trim().length() < 3 
				|| novoCliente.getEndereco().isEmpty() ) {
			mensagem = Mensagens.CLIENTE_ERRO_ENDERECO;
			return false;
		}
		return true;
	}
	
	private boolean validarCidade(ClienteVO novoCliente) {
		if(novoCliente.getCidade().trim().length() < 3 
				|| novoCliente.getCidade().isEmpty() ) {
			mensagem = Mensagens.CLIENTE_ERRO_CIDADE;
			return false;
		}
		return true;
	}

	private boolean validarEstado(ClienteVO novoCliente) {
		if(novoCliente.getEstado().isEmpty() ) {
			mensagem = Mensagens.CLIENTE_ERRO_ESTADO;
			return false;
		}
		return true;
	}
	private boolean validarCep(ClienteVO cep) {
		if(cep.getCep().trim().length() < 8
				|| cep.getCep().isEmpty()) {
			
			mensagem = Mensagens.CLIENTE_ERRO_CEP;
			return false;
		}
		return true;
} 
	
	public boolean Excluir(ClienteVO cpf) {
		
		
		return null;
		
	}

	
	public String gerarPlanilha(List<ClienteVO> dadosConsultados, String caminho) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ClienteVO> listarClientesFiltro(ClienteSeletor seletor) {
		ClienteDAO dao = new ClienteDAO();
		
		return dao.listarComSeletor(seletor);
	}


	
}
