package br.com.senac.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.constante.Mensagens;
import br.com.senac.controller.ClienteController;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.vo.ClienteVO;

public class ClienteBO {

	ClienteDAO dao = new ClienteDAO();

	String mensagem = "";
	
	public String cadastrarCliente(ClienteVO novoCliente) {

		if (validarNome(novoCliente) && validarSobrenome(novoCliente) && validarCpf(novoCliente)
				&& validarEmail(novoCliente) && validarCnh(novoCliente) && validarTefone(novoCliente)
				&& validarEndereco(novoCliente) && validarCidade(novoCliente) && validarEstado(novoCliente)
				&& validarCep(novoCliente)) {
			
			dao.inserir(novoCliente);

			mensagem = Mensagens.CLIENTE_SUCESSO;

		}
		return mensagem;
	}

	private boolean validarNome(ClienteVO novoCliente) {
		if (novoCliente.getNome().trim().length() < 3 || novoCliente.getNome().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_NOME;
			return false;
		}
		return true;
	}

	private boolean validarSobrenome(ClienteVO novoCliente) {
		if (novoCliente.getSobrenome().trim().length() < 3 || novoCliente.getSobrenome().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_SOBRENOME;
			return false;
		}
		return true;
	}

	private boolean validarCpf(ClienteVO novoCliente) {
		if (novoCliente.getCpf().length() < 11 || novoCliente.getCpf().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_CPF;
			return false;
	
		}else if(dao.cpfJaCadastrado(novoCliente.getCpf())) {
			mensagem = Mensagens.CLIENTE_ERRO_CPF_EXISTE;
			return false;
		}
		
		return true;
	}

	private boolean validarEmail(ClienteVO novoCliente) {
		if (novoCliente.getEmail().trim().length() < 3 || novoCliente.getEmail().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_EMAIL;
			return false;
		}
		return true;
	}

	private boolean validarCnh(ClienteVO cnh) {
		if (cnh.getCnh().trim().length() != 11 || cnh.getCnh().isEmpty()) {

			mensagem = Mensagens.CLIENTE_ERRO_CNH;
			return false;
		}
		return true;
	}

	private boolean validarTefone(ClienteVO telefone) {
		if (telefone.getTelefone().trim().length() != 14 || telefone.getTelefone().isEmpty()) {

			mensagem = Mensagens.CLIENTE_ERRO_TELFONE;
			return false;
		}
		return true;
	}

	private boolean validarEndereco(ClienteVO novoCliente) {
		if (novoCliente.getEndereco().trim().length() < 3 || novoCliente.getEndereco().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_ENDERECO;
			return false;
		}
		return true;
	}

	private boolean validarCidade(ClienteVO novoCliente) {
		if (novoCliente.getCidade().trim().length() < 3 || novoCliente.getCidade().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_CIDADE;
			return false;
		}
		return true;
	}

	private boolean validarEstado(ClienteVO novoCliente) {
		if (novoCliente.getEstado().isEmpty()) {
			mensagem = Mensagens.CLIENTE_ERRO_ESTADO;
			return false;
		}
		return true;
	}

	private boolean validarCep(ClienteVO cep) {
		if (cep.getCep().trim().length() < 8 || cep.getCep().isEmpty()) {

			mensagem = Mensagens.CLIENTE_ERRO_CEP;
			return false;
		}
		return true;
	}

	
	public String excluir(String cpf) {
	
		boolean excluiu = dao.excluir(cpf);

		if (excluiu) {
			mensagem = "Cliente excluido com sucesso!";
		} else {
			mensagem = "Erro ao excluir cliente";
		}

		return mensagem;
	}
	
}
