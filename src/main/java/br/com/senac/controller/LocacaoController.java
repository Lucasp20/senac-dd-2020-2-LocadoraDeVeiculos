package br.com.senac.controller;

import br.com.senac.model.dao.LocacaoDAO;
import br.com.senac.model.vo.LocacaoVO;

public class LocacaoController {

	/*
	 * 
	 * Locacao deve possuir data de entrega posterior a data de retirada
	 * Veiculo não pode ser alugado por duas pessoas ao mesmo tempo
	 * Km de entrega deve ser maior que km de de retirada 
	 * 
	 */
	private String mensagem = "";
	
	public String salvar(LocacaoVO novaLocacao) {
		
		
		if(validarDataLocacao(novaLocacao)
				&& validarKmLocacao(novaLocacao)
				&& validarDataEntrega(novaLocacao)
				&& validarKmEntrega(novaLocacao)) {
			
			LocacaoDAO locacaoDAO = new LocacaoDAO();
			locacaoDAO.inserir(novaLocacao);
	
			mensagem = "Locacao salva com sucesso! Id gerado: ";
	} 
	
	return mensagem;
}

	private boolean validarDataLocacao(LocacaoVO locacao) {
		if(locacao.getDataLocacao() == null) {
			mensagem = "Data da locação não é uma data valida";
		return false;
		}
	return true;
	}

	private boolean validarKmLocacao(LocacaoVO locacao) {
		// TODO Auto-generated method stub
		return false;
	}



	private boolean validarDataEntrega(LocacaoVO locacao) {
		if(locacao.getDataEntrega() == null) {
			mensagem = "Data da entrega não é uma data valida";
		return false;
		}
	return true;
	}

	private boolean validarKmEntrega(LocacaoVO kmentrega) {
		// TODO Auto-generated method stub
		return false;
	}

}
