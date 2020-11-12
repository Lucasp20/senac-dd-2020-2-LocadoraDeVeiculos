package br.com.senac.model.bo;

import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.vo.ClienteVO;


public class ClienteBO {

	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public boolean salvarCliente(ClienteVO novoCliente) {
		boolean salvou = false;
		int chaveGerada = this.clienteDAO.inserir(novoCliente);
		
		salvou = (chaveGerada > 0);
		
		return salvou;
	}	
}
