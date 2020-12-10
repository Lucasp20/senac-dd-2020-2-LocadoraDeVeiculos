package br.com.senac.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.senac.controller.ClienteController;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.vo.ClienteVO;

public class ClienteBO {

	ClienteDAO dao = new ClienteDAO();

	String mensagem = "";
	
	public String excluir(String cpf) {
	
		boolean excluiu = dao.excluir(cpf);

		if (excluiu) {
			mensagem = "Cliente excluido com sucesso!";
		} else {
			mensagem = "Erro ao excluir Cliente";
		}

		return mensagem;
	}
	
}
