package br.com.senac.controller;

import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.vo.ClienteVO;



public class ClienteController {

	/*
	 * 
	 * 4 - Cliente deve possuir cadastro completo, sem nada em branco
	 * 5 - CPF deve ser válido 11 caracteres
	 * 
	 * 
	 */
	
	private ClienteBO bo = new ClienteBO();
	
	public String salvar(ClienteVO cliente) {
		String situacao;
		situacao = "AQUI VÃO SER TRABALHADOS OS CONTROLLERS - apenas testandooo";
		return situacao;
		
	}
}
