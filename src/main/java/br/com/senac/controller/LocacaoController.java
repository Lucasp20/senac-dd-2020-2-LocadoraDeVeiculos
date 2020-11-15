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
	private String mensagem = " ";
	
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

	private boolean validarKmLocacao(LocacaoVO kmlocacao) {
		if(kmlocacao == null ) {
			mensagem = "Deve preencher a atual KM";
		return false;
		}
	return true;
	}

	private boolean validarDataEntrega(LocacaoVO locacao) {
		if(locacao.getDataEntrega() == null) {
			mensagem = "Data da devoluçao não é uma data valida";
		return false;
		}
	return true;
	}

	private boolean validarKmEntrega(LocacaoVO kmentrega) {
		if(kmentrega == null) {
			mensagem = "Deve preencher o KM de entrega do veículo";
		return false;
		}
		return true;
	}

}
