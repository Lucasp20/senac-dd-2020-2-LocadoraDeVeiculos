package br.com.senac.controller;

import java.util.List;

import javax.swing.JFormattedTextField;

import br.com.senac.constante.Mensagens;
import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.bo.VeiculoBO;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.util.GeradorPlanilhaCliente;
import br.com.senac.model.vo.ClienteVO;

public class ClienteController {

	
	private ClienteDAO clienteDAO = new ClienteDAO();
	ClienteBO clienteBO = new ClienteBO();


	public String cadastrarCliente(ClienteVO novoCliente) {
		return clienteBO.cadastrarCliente(novoCliente);
	}
	
	public boolean atualizarCliente(ClienteVO novoCliente) {
		return false;
	}

	public String excluirCliente(String cpf) {
		ClienteBO clienteBO = new ClienteBO();
		String mensagem = clienteBO.excluir(cpf);
		
		return mensagem;
	}

	public String gerarPlanilha(List<ClienteVO> dadosConsultados, String caminho) {

		GeradorPlanilhaCliente gerador = new GeradorPlanilhaCliente();
		return gerador.gerarPlanilhaClientes(caminho, dadosConsultados);
		
		}


	public List<ClienteVO> listarClientesFiltro(ClienteSeletor seletor) {
		ClienteDAO dao = new ClienteDAO();

		return dao.listarComSeletor(seletor); 
	}

	public ClienteVO pesquisarPorCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		
		return clienteDAO.pesquisarPorCpf(cpf);
		
	} 
	
	public void excluir(String cpf) {
		
	}

}
