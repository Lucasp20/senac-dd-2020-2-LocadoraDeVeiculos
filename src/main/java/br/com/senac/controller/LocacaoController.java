package br.com.senac.controller;

import java.sql.SQLException;

import br.com.senac.constante.Mensagens;
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
		
		
		if(validarCliente(novaLocacao)
				&& validarVeiculo(novaLocacao)
				&& validarDataLocacao(novaLocacao)
				&& validarKmLocacao(novaLocacao)
				&& validarDataEntrega(novaLocacao)
				&& validarKmEntrega(novaLocacao)) {
				LocacaoDAO locacaoDAO = new LocacaoDAO();
				locacaoDAO.inserir(novaLocacao);
	
			mensagem = "Locacao salva com sucesso!";
	} 
	
	return mensagem;
}

	private boolean validarCliente(LocacaoVO novaLocacao) {
		if(novaLocacao.getCliente() == null ){
			mensagem = "Deve Preencher o Campo Cliente";
			return false;
		}
		return true;
	}

	private boolean validarVeiculo(LocacaoVO novaLocacao) {
		if(novaLocacao.getVeiculo() == null ){
			mensagem = "Deve Preencher o Campo Veículo";
			return false;
		}
		return true;
	}

	private boolean validarDataLocacao(LocacaoVO novaLocacao) {
		if(novaLocacao.getDataLocacao() == null) {
			mensagem = "Data da locação não é uma data valida";
		return false;
		}
	return true;
	}

	private boolean validarKmLocacao(LocacaoVO kmLocacao) {
		if(kmLocacao == null) {
			mensagem = "Deve preencher a atual KM";
		return false;
		}
		return true;
	}

	private boolean validarDataEntrega(LocacaoVO novaLocacao) {
		if(novaLocacao.getDataEntrega() == null) {
			mensagem = "Data da devoluçao não é uma data valida";
		return false;
		}
	return true;
	}

	private boolean validarKmEntrega(LocacaoVO novaLocacao) {
		if(novaLocacao == null) {
			mensagem = "Deve preencher o KM de entrega do veículo";
		return false;
		}
	return true;
	}

}
