package br.com.senac.controller;

import java.util.List;

import javax.swing.JFormattedTextField;

import br.com.senac.constante.Mensagens;
import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.vo.ClienteVO;

public class ClienteController {

	
	private ClienteDAO clienteDAO = new ClienteDAO();

	
	private String mensagem = "";
	private String mensagemExcluido ="";

	public String cadastrarCliente(ClienteVO novoCliente) {

		if (validarNome(novoCliente) && validarSobrenome(novoCliente) && validarCpf(novoCliente)
				&& validarEmail(novoCliente) && validarCnh(novoCliente) && validarTefone(novoCliente)
				&& validarEndereco(novoCliente) && validarCidade(novoCliente) && validarEstado(novoCliente)
				&& validarCep(novoCliente)) {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.inserir(novoCliente);

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
		if (novoCliente.getCpf().length() < 11 || novoCliente.getCpf().isEmpty() || novoCliente.getCpf() == null) {
			mensagem = Mensagens.CLIENTE_ERRO_CPF;
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

	public boolean atualizarCliente(ClienteVO novoCliente) {

		return false;
	}

	public String excluirCliente(ClienteVO clienteExcluido) {
		boolean excluiu = clienteDAO.excluir(clienteExcluido.getCpf());
		
		if(excluiu) {
			mensagemExcluido = "Cliente excluido com sucesso!";
			
		}else {
			mensagemExcluido = "Erro ao excluir Cliente";
		}
		
		return mensagemExcluido;
	}

	public String gerarPlanilha(List<ClienteVO> dadosConsultados, String caminho) {
				
		return null;
	}

	public List<ClienteVO> listarClientesFiltro(ClienteSeletor seletor) {
		ClienteDAO dao = new ClienteDAO();

		return dao.listarComSeletor(seletor); 
	}

}
